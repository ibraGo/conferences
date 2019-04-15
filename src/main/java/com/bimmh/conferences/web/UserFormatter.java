package com.bimmh.conferences.web;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.bimmh.conferences.model.User;

public class UserFormatter implements Formatter<User> {

	@Override
	public String print(User user, Locale locale) {
		return user.getId() + "";
	}

	@Override
	public User parse(String id, Locale locale) throws ParseException {
		User user = new User();
		user.setId(Long.parseLong(id));
		return user;
	}
}
