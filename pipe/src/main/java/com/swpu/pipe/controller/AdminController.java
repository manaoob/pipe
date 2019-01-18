package com.swpu.pipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swpu.pipe.biz.AdminService;
import com.swpu.pipe.entity.Admin;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping(value="verify")
	public String verifyAdmin(Admin admin,Model model){
		if (adminService.verifyAdmin(admin)) {
			return "adminInterface";
		}
		return "login";
	}
}
