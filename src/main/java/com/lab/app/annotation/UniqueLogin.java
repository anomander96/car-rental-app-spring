package com.lab.app.annotation;

import java.lang.annotation.*;
import javax.validation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueLoginValidator.class)
public @interface UniqueLogin {

    String message() default "User with such login already exist, try another one";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
