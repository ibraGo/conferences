package com.bimmh.conferences.web;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.bimmh.conferences.model.Profession;

public class ProfessionFormatter implements Formatter<Profession> {

	@Override
	public String print(Profession profession, Locale locale) {
		return profession.getId() + "";
	}

	@Override
	public Profession parse(String id, Locale locale) throws ParseException {
		Profession profession = new Profession();
		profession.setId(Long.parseLong(id));
		return profession;
	}
}
