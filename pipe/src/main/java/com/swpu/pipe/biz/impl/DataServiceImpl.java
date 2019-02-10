package com.swpu.pipe.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swpu.pipe.biz.DataService;
import com.swpu.pipe.dao.DataDao;
import com.swpu.pipe.dto.QueryData;
import com.swpu.pipe.entity.InputData;
import com.swpu.pipe.entity.ResultData;

@Service
@Transactional
public class DataServiceImpl implements DataService {

	@Autowired
	private DataDao dataDao;
	@Override
	public boolean saveData(InputData inputData) {
		return dataDao.save(inputData) != null;
	}
	@Override
	public ResultData showData(QueryData queryData) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean saveResultData(ResultData resultData) {
		// TODO Auto-generated method stub
		return dataDao.save(resultData) != null;
	}
	@Override
	public ResultData selectNewResultData() {
		// TODO Auto-generated method stub
		return dataDao.showNewResultData();
	}

}
