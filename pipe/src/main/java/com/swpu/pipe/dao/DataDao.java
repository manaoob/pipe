package com.swpu.pipe.dao;

import com.swpu.pipe.dto.QueryData;
import com.swpu.pipe.entity.InputData;
import com.swpu.pipe.entity.ResultData;

public interface DataDao extends BaseDao<InputData, Integer>{

	public ResultData queryResultData(QueryData queryData);
	
	public Integer save(ResultData entity);
	
	public ResultData showNewResultData();
}
