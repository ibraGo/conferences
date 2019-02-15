package com.bimmh.conferences.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bimmh.conferences.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);

	List<User> findByRoleName(String roleName);

	List<User> findByRoleNameNotIn(Collection<String> rolesName);
}
