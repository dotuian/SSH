package com.dotuian.ssh.dao;

import java.util.List;

import com.dotuian.ssh.domain.User;

/**
 * UserDao接口
 * 
 */
public interface UserDao {

	public void createUser(User user);
	
	public void deleteUser(User user);

	public User findUserById(long id);

	public void updateUser(User user);
	
	public List<User> getAllUsers();
}
