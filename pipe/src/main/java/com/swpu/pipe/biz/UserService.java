package com.swpu.pipe.biz;



import com.swpu.pipe.beans.PageBean;
import com.swpu.pipe.dto.UserEditPassDto;
import com.swpu.pipe.entity.User;

public interface UserService {
	
	public boolean login(User user);
	
	public boolean register(User user);
	
	public User findByUsername(String username);
	
	public boolean updateUser(User user);
	
	public PageBean<User> findAll(int page, int size);
	
	public boolean delete(User user);
	
	public boolean updatePassword(UserEditPassDto userEditPassDto);
	
}
