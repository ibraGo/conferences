package com.bimmh.conferences.validator;

import com.bimmh.conferences.model.Conference;
import com.bimmh.conferences.model.Profession;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProfessionValidator implements Validator {



    @Override
    public boolean supports(Class<?> aClass) {
        return Profession.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Profession profession = (Profession) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "label", "NotEmpty");
    }
}
