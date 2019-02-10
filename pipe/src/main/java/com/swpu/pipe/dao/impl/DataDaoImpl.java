package com.swpu.pipe.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swpu.pipe.beans.PageBean;
import com.swpu.pipe.dao.DataDao;
import com.swpu.pipe.dto.QueryData;
import com.swpu.pipe.entity.InputData;
import com.swpu.pipe.entity.ResultData;
import com.swpu.pipe.entity.User;

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

	@Override
	public Integer save(ResultData entity) {
		// TODO Auto-generated method stub
		return (Integer) SessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public ResultData showNewResultData() {
		Integer id =  ((Integer) SessionFactory.getCurrentSession().createQuery("SELECT MAX(resultDataId) from tb_resultdata").uniqueResult()).intValue();
		ResultData resultData =	(ResultData) SessionFactory.getCurrentSession().createQuery("from ResultData R where R.resultDataId=:resultDataId")
				.setParameter("resultDataId", id).uniqueResult();
		return resultData;
	}

}
