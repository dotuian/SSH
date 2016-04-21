package com.dotuian.ssh.dao.imp;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dotuian.ssh.dao.UserDao;
import com.dotuian.ssh.domain.User;

public class UserDaoImp extends HibernateDaoSupport implements UserDao {

	@Override
	public void createUser(User user) {
		this.getSession().save(user);
	}

	@Override
	public User findUserById(long id) {
		return (User) this.getSession().load(User.class, id);
	}

	@Override
	public void updateUser(User user) {
		this.getSession().update(user);
	}

	public List<User> getAllUsers() {
		return (List<User>) this.getHibernateTemplate().find("from User");
	}

	public void deleteUser(User user) {
		this.getSession().delete(user);
	}

}
