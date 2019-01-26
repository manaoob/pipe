package com.swpu.pipe.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swpu.pipe.beans.PageBean;
import com.swpu.pipe.dao.DataDao;
import com.swpu.pipe.dto.QueryData;
import com.swpu.pipe.entity.InputData;
import com.swpu.pipe.entity.ResultData;

@Repository
public class DataDaoImpl implements DataDao{


	@Autowired
	private SessionFactory SessionFactory;
	@Override
	public Integer save(InputData entity) {
		return (Integer) SessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public boolean delete(InputData entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(Integer k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(InputData entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer findById(Integer k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InputData> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(InputData entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PageBean<InputData> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultData queryResultData(QueryData queryData) {
		
		
		
		return null;
	}

}
