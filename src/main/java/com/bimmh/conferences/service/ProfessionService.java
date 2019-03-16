package com.bimmh.conferences.service;

import java.util.List;

import com.bimmh.conferences.model.Profession;

public interface ProfessionService {

	Profession getById(long id);

	List<Profession> getAll();
}
