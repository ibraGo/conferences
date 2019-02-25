package com.bimmh.conferences.validator;

import com.bimmh.conferences.model.Conference;
import com.bimmh.conferences.model.User;
import com.bimmh.conferences.service.UserService;
import com.bimmh.conferences.web.ConferenceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.sql.Date;

@Component
public class ConferenceValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Conference.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Conference conference = (Conference) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "durationDays", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startSubmission", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endSubmission", "NotEmpty");
        if (conference.getDurationDays() == null || conference.getDurationDays().intValue() <= 0 || conference.getDurationDays().intValue() > 30) {
            errors.rejectValue("durationDays", "Conference.durationDays.size");
        }
    }
}
