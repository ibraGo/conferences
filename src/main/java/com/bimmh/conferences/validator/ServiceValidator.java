package com.bimmh.conferences.validator;

import com.bimmh.conferences.model.Conference;
import com.bimmh.conferences.model.Service;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ServiceValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Service.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Service service = (Service) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "label", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prix", "NotEmpty");
    }
}
