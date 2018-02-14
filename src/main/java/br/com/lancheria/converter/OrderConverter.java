package br.com.lancheria.converter;

import br.com.lancheria.model.entity.*;
import br.com.lancheria.vo.OrderVO;

import javax.validation.constraints.NotNull;

public class OrderConverter {

    public static Order toEntity(@NotNull OrderVO orderVO) {
        Order entity = new Order();
        orderVO.getSnacks().forEach(s -> {
            Snack snack = new Snack();
            snack.addServings(new Servings(s.getBreadId()));
            snack.addServings(new Servings(s.getCheeseId(), s.getDoubleCheese() ? 2 : 1));
            snack.addServings(new Servings(s.getFillingId(), s.getDoubleFilling() ? 2 : 1));
            snack.addServings(new Servings(s.getSaladId(), s.getDoubleSalad() ? 2 : 1));
            entity.addSnack(snack);
        });
        //orderVO.getPaymentSplit().forEach();
        return entity;
    }

}
