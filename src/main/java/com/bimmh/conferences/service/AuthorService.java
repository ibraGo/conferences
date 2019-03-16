package com.bimmh.conferences.service;

import java.util.List;

import com.bimmh.conferences.model.User;

public interface AuthorService {

	User getById(long id);

	List<User> getAll();

}
