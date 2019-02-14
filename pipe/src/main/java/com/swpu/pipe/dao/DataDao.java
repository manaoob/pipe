package com.swpu.pipe.dao;

import java.util.List;

import com.swpu.pipe.dto.QueryData;
import com.swpu.pipe.entity.InputData;
import com.swpu.pipe.entity.ResultData;

public interface DataDao extends BaseDao<InputData, Integer>{

	public ResultData queryResultData(QueryData queryData);
	
	public Integer save(ResultData entity);
	
	public ResultData showNewResultData();
	
	public List<ResultData> ansysData(QueryData queryData, String index);

	public InputData findInputData(InputData inputData);
	
	public boolean deleteDataById(int id);
}
