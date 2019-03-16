package com.bimmh.conferences.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bimmh.conferences.model.User;
import com.bimmh.conferences.repository.UserRepository;

@Service
public class DefaultAuthorService implements AuthorService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User getById(long id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findByRoleName("ROLE_AUTHOR");
	}

}
