package com.swpu.pipe.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swpu.pipe.biz.UserService;
import com.swpu.pipe.dao.UserDao;
import com.swpu.pipe.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	/**
	 * 登录的业务逻辑
	 */
	@Override
	public boolean login(User user) {
		User temp = userDao.findByUsername(user.getUsername());
		if (temp != null) {
			return temp.getPassword().equals(user.getPassword());
		}
		return false;
	}
	
	/**
	 * 注册的业务逻辑实现
	 */
	@Override
	public boolean register(User user) {
		List<User> users = userDao.findAll();
		for (int i = 0; i < users.size(); i++) {
			if (user.getUsername().equals(users.get(i).getUsername())) {
				return false;
			}
			
		}
		return userDao.add(user);		
	}

	@Override
	public User findByUsername(String username) {
		
		return userDao.findByUsername(username);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}

}
