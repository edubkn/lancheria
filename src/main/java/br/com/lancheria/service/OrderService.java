package br.com.lancheria.service;

import br.com.lancheria.converter.OrderConverter;
import br.com.lancheria.exception.OrderCalculationException;
import br.com.lancheria.model.entity.Ingredient;
import br.com.lancheria.model.entity.Order;
import br.com.lancheria.model.repository.IngredientRepository;
import br.com.lancheria.model.repository.OrderRepository;
import br.com.lancheria.model.repository.UserRepository;
import br.com.lancheria.vo.OrderVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {

    private static final Logger LOG = LoggerFactory.getLogger(OrderService.class);

    private OrderRepository orderRepository;
    private IngredientRepository ingredientRepository;
    private UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, IngredientRepository ingredientRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.ingredientRepository = ingredientRepository;
        this.userRepository = userRepository;
    }

    public Long placeOrder(OrderVO orderVO) throws OrderCalculationException {
        Order order = OrderConverter.toEntity(orderVO);
        try {
            //TODO: tratar usuário inexistente
            order.setUser(userRepository.findByFacebookId(orderVO.getUserFacebookId()));
            order.setTotal(calculateValue(order));
            return orderRepository.save(order).getId();
        } catch (OrderCalculationException e) {
            LOG.warn(e.getMessage());
            throw e;
        }
    }

    private BigDecimal calculateValue(Order order) throws OrderCalculationException {
        return order.getSnacks().stream()
                .flatMap(s -> s.getServings().stream())
                .peek(s -> {
                    Ingredient entity = ingredientRepository.findById(s.getIngredient().getId());
                    s.getIngredient().setName(entity.getName());
                    s.getIngredient().setType(entity.getType());
                    s.getIngredient().setValue(entity.getValue());
                })
                .map(s -> s.getIngredient().getValue().multiply(BigDecimal.valueOf(s.getQuantity())))
                .reduce(BigDecimal::add)
                .orElseThrow(() -> new OrderCalculationException(
                        "There was a problem when calculating the order total! Please try placing your order again"));
    }
}
