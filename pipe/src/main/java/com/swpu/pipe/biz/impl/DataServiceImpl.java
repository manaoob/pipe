package com.swpu.pipe.biz.impl;

import java.util.List;

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
		
		return dataDao.queryResultData(queryData);
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
	@Override
	public List<ResultData> ansysData(QueryData queryData, String index) {
		// TODO Auto-generated method stub
		return dataDao.ansysData(queryData, index);
	}
	@Override
	public InputData selectInputData(InputData inputData) {
		// TODO Auto-generated method stub
		return dataDao.findInputData(inputData);
	}
	@Override
	public boolean deleteData(int id) {
		// TODO Auto-generated method stub
		return dataDao.deleteDataById(id);
	}

}
