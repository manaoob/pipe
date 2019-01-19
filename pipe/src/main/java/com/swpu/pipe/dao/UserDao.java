package com.swpu.pipe.dao;

import com.swpu.pipe.dto.UserEditPassDto;
import com.swpu.pipe.entity.User;

public interface UserDao extends BaseDao<User, Integer> {

	public User findByUsername(String userName);
	
	public boolean updatePassword(UserEditPassDto userEditPassDto);
	
}
