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
	 * ��ת��¼����
	 * @return ��¼�����JSP
	 */
	@GetMapping(value="/toLogin")
	public String toLogin(HttpServletRequest request, HttpServletResponse response){
		return "login";
	}
	
	/**
	 * ��¼����
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
				model.addAttribute("hint", "�û������¼������󣬵�¼ʧ�ܣ���");
				return "login";			
			}
		}
		else {
			model.addAttribute("hint", "��֤�����!!");
			return "login";	
		}
	
	}
	/**
	 * ע������
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
	 * ע�Ṧ��
	 * @param user
	 * @param rePassword
	 * @param model
	 * @return
	 */
	@PostMapping(value="/register")
	public String register(UserRegDto userRegDto,Model model){
		if (userRegDto.getPassword() == userRegDto.getRePassword()) {
			if (userService.register(userRegDto.toUser())) {
				model.addAttribute("hint","ע��ɹ�����");
				return "login";
			}
			else {
				model.addAttribute("hint","�û����ظ���ע��ʧ�ܣ���");
				return "register";
			}
		}
		else {
			model.addAttribute("hint","�������벻һ�£�ע��ʧ�ܣ���");
			return "register";
		}
		
	}
	/**
	 * �û�������Ϣ���޸�
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
				model.addAttribute("hint", "������Ϣʧ�ܣ���");			
				return "profile";
			}
		}
		model.addAttribute("hint", "�޸���Ϣʧ�ܣ���");
		return "profile";
	}
	
	/**
	 * ������֤��
	 * @param request
	 * @param response
	 */
	@GetMapping(value = "/VerifyCode")
    public void VerifyCode(HttpServletRequest request, HttpServletResponse response) {
		PipeUtil.CreateQRCode(request, response);
    }
	
	
	/**
	 * ��תע�����
	 * @return ע������JSP
	 */
	@GetMapping(value="/toRegister")
	public String toRegister(){
	
		return "register";
	}
	/**
	 * ������Ϣ��ʾ��Ϣ
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
