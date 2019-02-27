package com.bimmh.conferences.validator;

import com.bimmh.conferences.model.Conference;
import com.bimmh.conferences.model.Evaluation;
import com.bimmh.conferences.web.ConferenceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EvaluationValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Evaluation.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Evaluation evaluation = (Evaluation) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "judge", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "presentation", "NotEmpty");
    }
}
