package br.com.lancheria.validator;

import br.com.lancheria.validator.constraint.IsHundredPercent;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;
import java.util.Map;

public class HundredPercentValidator implements ConstraintValidator<IsHundredPercent, Map<Integer, BigDecimal>> {


    @Override
    public void initialize(IsHundredPercent constraintAnnotation) {
    }

    @Override
    public boolean isValid(Map<Integer, BigDecimal> paymentSplit, ConstraintValidatorContext context) {
        return paymentSplit.values().stream().reduce(BigDecimal::add).get().compareTo(BigDecimal.valueOf(100)) == 0;
    }
}
