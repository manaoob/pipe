package com.swpu.pipe.dao;

import com.swpu.pipe.entity.Admin;


public interface AdminDao extends BaseDao<Admin, Integer>{

	public Admin findByAdminName(String AdminName);
}
