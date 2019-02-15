package com.bimmh.conferences.service;

import com.bimmh.conferences.model.User;

public interface UserService {
	void save(User user);

	User findByUsername(String username);
}
