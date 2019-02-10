package com.swpu.pipe.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swpu.pipe.biz.UserService;

@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private UserService userService;
	
	/**
	 * ��תע�����
	 * @return ע������JSP
	 */
	@GetMapping(value="/toRegister")
	public String toRegister(){
	
		return "register";
	}
	/**
	 * ��ת��¼����
	 * @return ��¼�����JSP
	 */
	@GetMapping(value="/toLogin")
	public String toLogin(){
	
		return "login";
	}
	
}
