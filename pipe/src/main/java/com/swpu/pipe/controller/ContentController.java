package com.swpu.pipe.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swpu.pipe.biz.UserService;
import com.swpu.pipe.dto.UserLonDto;
import com.swpu.pipe.dto.UserRegDto;
import com.swpu.pipe.entity.User;

@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private UserService userService;
	
	/**
	 * 跳转注册界面
	 * @return 注册界面的JSP
	 */
	@GetMapping(value="/toRegister")
	public String toRegister(){
	
		return "register";
	}
	/**
	 * 跳转登录界面
	 * @return 登录界面的JSP
	 */
	@GetMapping(value="/toLogin")
	public String toLogin(){
	
		return "login";
	}
	
}
