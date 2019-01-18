package com.swpu.pipe.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.swpu.pipe.beans.PageBean;
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
	public boolean deleteById(Integer k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User entity) {
	return SessionFactory.getCurrentSession().createQuery("update User u set u.nickName=:nickName,"
				+ "u.birthday=:birthday, u.photo=:photo, u.phone=:phone, u.QQorWechat=:QQorWechat,"
				+ "u.email=:email, u.notes=:notes where u.username=:username").setParameter("nickName", entity.getNickName())
		        .setParameter("birthday", entity.getBirthday()).setParameter("photo", entity.getPhoto())
		        .setParameter("phone", entity.getPhone()).setParameter("QQorWechat", entity.getQQorWechat())
		        .setParameter("email", entity.getEmail()).setParameter("notes", entity.getNotes())
		        .setParameter("username", entity.getUsername()).executeUpdate() == 1;
//		SessionFactory.getCurrentSession().createQuery("update User set nickName=?,"
//			+ "birthday=?, photo=?, phone=?, QQorWechat=?,"
//			+ "email=?, notes=? where username=?").setParameter(0, entity.getNickName())
//	        .setParameter(1, entity.getBirthday()).setParameter(2, entity.getPhoto())
//	        .setParameter(3, entity.getPhone()).setParameter(4, entity.getQQorWechat())
//	        .setParameter(5, entity.getEmail()).setParameter(6, entity.getNotes())
//	        .setParameter(7, entity.getUsername());		
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

	@SuppressWarnings("unchecked")
	@Override
	public PageBean<User> findAll(int page, int size) {
		//List<CivilServant> dataList = (List<CivilServant>) sqlSession.getMapper(CivilServantMapper.class).findAllCivil(stateName);
		List<User> dataList = SessionFactory.getCurrentSession().createQuery("from User")
				.setFirstResult((page - 1) * size).
				setMaxResults(size).getResultList();
		int total = ((Long) SessionFactory.getCurrentSession().createQuery("select count(*) from User")
				.uniqueResult()).intValue();		
		return new PageBean<User>(dataList, page, size, total);
	}



	@Override
	public boolean delete(User entity) {
		SessionFactory.getCurrentSession().delete(entity);
		return true;
	}
	

}
