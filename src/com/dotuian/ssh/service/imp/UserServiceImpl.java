package com.dotuian.ssh.service.imp;

import java.util.ArrayList;
import java.util.List;

import com.dotuian.ssh.dao.UserDao;
import com.dotuian.ssh.domain.User;
import com.dotuian.ssh.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Override
	public List<User> getAllUsers() {
		return this.userDao.getAllUsers();
	}

	@Override
	public List<User> findUsersByValue(String value) {
		List<User> users = this.userDao.getAllUsers();

		if (value == null || "".equals(value)) {
			return users;
		}

		List<User> dataList = new ArrayList<User>();

		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			if (user.getUsername().indexOf(value) > -1 || user.getPassword().indexOf(value) > -1
					|| user.getEmail().indexOf(value) > -1) {
				dataList.add(user);
			}
		}

		return dataList;
	}

	@Override
	public User getUserById(String id) {
		return this.userDao.findUserById(Long.valueOf(id));
	}

	@Override
	public User deleteUserById(String id) {
		User user = this.getUserDao().findUserById(Long.valueOf(id));
		if (user != null) {
			this.userDao.deleteUser(user);
		}

		return user;
	}

	public User createUser(String username, String password, String email) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		this.userDao.createUser(user);

		return user;
	}

	@Override
	public User updateUser(String id, String username, String password, String email) {
		User user = this.getUserDao().findUserById(Long.valueOf(id));
		if (user != null) {
			user.setEmail(email);
			this.userDao.updateUser(user);
		}

		return user;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
