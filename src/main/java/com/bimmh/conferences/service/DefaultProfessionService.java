package com.bimmh.conferences.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bimmh.conferences.model.Profession;
import com.bimmh.conferences.repository.ProfessionRepository;

@Service
public class DefaultProfessionService implements ProfessionService {

	@Autowired
	ProfessionRepository professionRepository;

	@Override
	public Profession getById(long id) {
		return professionRepository.getOne(id);
	}

	@Override
	public List<Profession> getAll() {
		return professionRepository.findAll();
	}

}
