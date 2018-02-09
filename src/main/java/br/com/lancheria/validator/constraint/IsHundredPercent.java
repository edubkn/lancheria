package br.com.lancheria.validator.constraint;

import br.com.lancheria.validator.HundredPercentValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = HundredPercentValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsHundredPercent {
    String message() default "The payment split is not equals a hundred percent!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
