package com.swpu.pipe.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swpu.pipe.dao.UserDao;
import com.swpu.pipe.entity.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory SessionFactory;
	@Override
	public Integer save(User entity) {

		return (Integer) SessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteById(Integer k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User entity) {
		SessionFactory.getCurrentSession().update(entity.getUsername(), entity);
		
		return true;
	}

	@Override
	public Integer findById(Integer k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return SessionFactory.getCurrentSession().createQuery("from User").getResultList();
	}

	@Override
	public User findByUsername(String userName) {
		User user = (User) SessionFactory.getCurrentSession().createQuery("from User u where u.username=:userName")
				.setParameter("userName", userName).uniqueResult();
		return user;
	}

	@Override
	public boolean add(User entity) {
		return SessionFactory.getCurrentSession().save(entity) != null;
		
	}
	

}
