package com.bimmh.conferences.validator;

import com.bimmh.conferences.model.Evaluation;
import com.bimmh.conferences.model.ProgramSection;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProgramSectionValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return ProgramSection.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProgramSection programSection = (ProgramSection) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "label", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDate", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "conference", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "presentation", "NotEmpty");
    }
}
