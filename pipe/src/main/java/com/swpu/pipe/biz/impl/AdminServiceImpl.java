package com.swpu.pipe.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.swpu.pipe.biz.AdminService;
import com.swpu.pipe.dao.AdminDao;
import com.swpu.pipe.entity.Admin;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	/**
	 * 验证是否为管理员
	 */
	@Override
	public boolean verifyAdmin(Admin admin) {
		Admin admin2 = adminDao.findByAdminName(admin.getAdminName());
		if (admin2==null) {
			return false;
		}
		return admin2.getPassword().equals(admin.getPassword());
	}

}
