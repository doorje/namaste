package com.mahen.doorje.namaste.client.validation;

import com.mahen.doorje.namaste.client.web.dto.NamasteAccountDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final NamasteAccountDto account = (NamasteAccountDto) obj;
        return account.getPassword().equals(account.getMatchingPassword());
    }
}
