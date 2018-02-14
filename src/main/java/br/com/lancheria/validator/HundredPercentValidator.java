package br.com.lancheria.validator;

import br.com.lancheria.validator.constraint.IsHundredPercent;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

public class HundredPercentValidator implements ConstraintValidator<IsHundredPercent, Map<Integer, BigDecimal>> {


    @Override
    public void initialize(IsHundredPercent constraintAnnotation) {
    }

    @Override
    public boolean isValid(Map<Integer, BigDecimal> paymentSplit, ConstraintValidatorContext context) {
        if (paymentSplit == null) {
            return false;
        }
        return paymentSplit.values().stream()
                                    .reduce(BigDecimal::add)
                                    .map(s -> s.compareTo(BigDecimal.valueOf(100)) == 0)
                                    .orElse(false);
    }
}
