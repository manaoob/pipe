package com.swpu.pipe.dao;

import com.swpu.pipe.entity.User;

public interface UserDao extends BaseDao<User, Integer> {

	public User findByUsername(String userName);
	
}
