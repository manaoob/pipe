package com.swpu.pipe.biz.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swpu.pipe.beans.PageBean;
import com.swpu.pipe.biz.UserService;
import com.swpu.pipe.dao.UserDao;
import com.swpu.pipe.entity.User;
import com.swpu.pipe.util.MD5Util;

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
			try {
				return temp.getPassword().equals(MD5Util.EncoderByMd5(user.getPassword()));
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		try {
			String password = MD5Util.EncoderByMd5(user.getPassword());
			user.setPassword(password);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDao.add(user);		
	}

	@Override
	public User findByUsername(String username) {
		
		return userDao.findByUsername(username);
	}

	
	@Override
	public boolean updateUser(User user) {
		return userDao.update(user);
	}

	
	@Override
	public PageBean<User> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return userDao.findAll(page, size);
	}

	@Override
	public boolean delete(User user) {
		
		return userDao.delete(user);
	}

}
