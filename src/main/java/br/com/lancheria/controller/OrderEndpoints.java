package br.com.lancheria.controller;

import br.com.lancheria.service.OrderService;
import br.com.lancheria.vo.OrderVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static br.com.lancheria.controller.OrderEndpoints.PATH_ORDER;

@RestController
@RequestMapping(PATH_ORDER)
public class OrderEndpoints {

    public static final String PATH_ORDER = "/order";

    private final OrderService orderService;

    public OrderEndpoints(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void placeOrder(@RequestBody @Valid OrderVO order) {

    }
}
