package com.swpu.pipe.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.swpu.pipe.biz.UserService;
import com.swpu.pipe.dto.UserInfoChangeDto;
import com.swpu.pipe.dto.UserLonDto;
import com.swpu.pipe.dto.UserRegDto;
import com.swpu.pipe.entity.User;
import com.swpu.pipe.util.PipeUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 跳转登录界面
	 * @return 登录界面的JSP
	 */
	@GetMapping(value="/toLogin")
	public String toLogin(HttpServletRequest request, HttpServletResponse response){
		return "login";
	}
	
	/**
	 * 登录功能
	 * @param user
	 * @param model
	 * @return
	 */
	@PostMapping(value="/login")
	public String login(@Valid UserLonDto userLonDto, Model model, HttpServletRequest request, HttpServletResponse response){
		String code = (String) request.getSession().getAttribute("code");
		if (userLonDto.getVcode().equalsIgnoreCase(code)) {
			User user = userLonDto.toUser(userLonDto);
			if (userService.login(user)) {
				
				request.getSession().setAttribute("username", user.getUsername());
				model.addAttribute("user", user);
				return "profile";
			}
			else {
				model.addAttribute("hint", "用户名或登录密码错误，登录失败！！");
				return "login";			
			}
		}
		else {
			model.addAttribute("hint", "验证码错误!!");
			return "login";	
		}
	
	}
	/**
	 * 注销功能
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		request.getSession().removeAttribute("username");
		return "login";
	}
	/**
	 * 注册功能
	 * @param user
	 * @param rePassword
	 * @param model
	 * @return
	 */
	@PostMapping(value="/register")
	public String register(UserRegDto userRegDto,Model model){
		if (userRegDto.getPassword() == userRegDto.getRePassword()) {
			if (userService.register(userRegDto.toUser())) {
				model.addAttribute("hint","注册成功！！");
				return "login";
			}
			else {
				model.addAttribute("hint","用户名重复，注册失败！！");
				return "register";
			}
		}
		else {
			model.addAttribute("hint","密码输入不一致，注册失败！！");
			return "register";
		}
		
	}
	/**
	 * 用户个人信息的修改
	 * @param userInfoChangeDto
	 * @param photo
	 * @param model
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@PostMapping(value="infoChange")
	public String infoChange(UserInfoChangeDto userInfoChangeDto,Errors errors,MultipartFile photo, Model model,HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		if (!errors.hasErrors()) {
			ServletContext context = request.getServletContext();
			String path = context.getRealPath("/images");
			System.out.println(photo);
			String fileName = PipeUtil.getRandomFileName(photo.getOriginalFilename());
			photo.transferTo(new File(path + "/" + fileName));
			User user = userInfoChangeDto.toUser(userInfoChangeDto);
			user.setPhoto(fileName);
			if (userService.updateUser(user)) {
				model.addAttribute("user", user);			
				return "profile";
			}
			else {
				model.addAttribute("hint", "保存信息失败！！");			
				return "profile";
			}
		}
		model.addAttribute("hint", "修改信息失败！！");
		return "profile";
	}
	
	/**
	 * 生成验证码
	 * @param request
	 * @param response
	 */
	@GetMapping(value = "/VerifyCode")
    public void VerifyCode(HttpServletRequest request, HttpServletResponse response) {
		PipeUtil.CreateQRCode(request, response);
    }
	
	
	/**
	 * 跳转注册界面
	 * @return 注册界面的JSP
	 */
	@GetMapping(value="/toRegister")
	public String toRegister(){
	
		return "register";
	}
	/**
	 * 个人信息显示信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@GetMapping(value="/toPro")
	public String toPro(HttpServletRequest request, HttpServletResponse response,Model model){
		String username = (String) request.getSession().getAttribute("username");
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "profile";
	}	
	@GetMapping(value="/toIndex")
	public String toIndex(){
		return "index";
	}
	@GetMapping(value="/toUI")
	public String toUI(){
		return "ui";
	}
	@GetMapping(value="/toTable")
	public String toTable(){
		return "table";
	}
	@GetMapping(value="/toForms")
	public String toForms(){
		return "forms";
	}
	@GetMapping(value="/toBlank")
	public String toBlank(){
		return "blank";
	}

	
}
