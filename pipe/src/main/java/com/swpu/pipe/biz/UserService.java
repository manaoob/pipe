package com.swpu.pipe.biz;



import com.swpu.pipe.entity.User;

public interface UserService {
	
	public boolean login(User user);
	
	public boolean register(User user);
	
	public User findByUsername(String username);
	
	public boolean updateUser(User user);
	
}
