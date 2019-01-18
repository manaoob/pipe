package com.swpu.pipe.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swpu.pipe.beans.PageBean;
import com.swpu.pipe.dao.AdminDao;
import com.swpu.pipe.entity.Admin;


@Repository
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private SessionFactory SessionFactory;
	@Override
	public Integer save(Admin entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean deleteById(Integer k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Admin entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer findById(Integer k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Admin entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin findByAdminName(String AdminName) {
		Admin admin = (Admin) SessionFactory.getCurrentSession().createQuery("from Admin u where u.adminName=:adminName")
				.setParameter("adminName", AdminName).uniqueResult();
		return admin;
	}

	@Override
	public PageBean<Admin> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean delete(Admin entity) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
