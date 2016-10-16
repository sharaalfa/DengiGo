package com.ushara.dengigo.validators;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = PasswordValidator.class)
@Documented
public @interface PasswordMatcher {
}
