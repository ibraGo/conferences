package com.bimmh.conferences.validator;

import com.bimmh.conferences.model.Conference;
import com.bimmh.conferences.model.Presentation;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PresentationValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Presentation.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Presentation presentation = (Presentation) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "speaker", "NotEmpty");
    }
}
