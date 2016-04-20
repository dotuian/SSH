package com.dotuian.drp.service;

import java.util.List;

import com.dotuian.drp.domain.User;

/**
 * UserService接口定义
 *
 */
public interface UserService {
	
	public List<User> getAllUsers();
	
	public User getUserById(String id);

	public User deleteUserById(String id);

	public User createUser(String username, String password, String email);
	
	public User updateUser(String id, String username, String password, String email);
	
	public List<User> findUsersByValue(String value);
	
}
