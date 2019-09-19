package com.deviceshop.validation.validator;

import com.deviceshop.repository.UserRepository;
import com.deviceshop.validation.annotation.UsernameUnique;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameUniqueValidator implements ConstraintValidator<
        UsernameUnique, String> {

    private UserRepository userRepository;

    public UsernameUniqueValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void initialize(final UsernameUnique constraint) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return !userRepository.existsByUsername(username);
    }

}
