package com.swpu.pipe.biz;

import java.util.List;

import com.swpu.pipe.dto.QueryData;
import com.swpu.pipe.entity.InputData;
import com.swpu.pipe.entity.ResultData;

public interface DataService {

	public boolean saveData(InputData inputData);
	
	public ResultData showData(QueryData queryData);
	
	public boolean saveResultData(ResultData resultData);
	
	public ResultData selectNewResultData();
	
	public List<ResultData> ansysData(QueryData queryData, String index);
	
	public InputData selectInputData(InputData inputData);
	
	public boolean deleteData(int id);
}
