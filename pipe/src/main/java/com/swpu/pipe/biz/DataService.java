package com.swpu.pipe.biz;

import com.swpu.pipe.dto.QueryData;
import com.swpu.pipe.entity.InputData;
import com.swpu.pipe.entity.ResultData;

public interface DataService {

	public boolean saveData(InputData inputData);
	
	public ResultData showData(QueryData queryData);
}
