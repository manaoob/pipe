package com.swpu.pipe.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.swpu.pipe.beans.PageBean;
import com.swpu.pipe.biz.AdminService;
import com.swpu.pipe.biz.DataService;
import com.swpu.pipe.biz.UserService;
import com.swpu.pipe.dto.UserEditPassDto;
import com.swpu.pipe.dto.UserInfoChangeDto;
import com.swpu.pipe.dto.UserLonDto;
import com.swpu.pipe.dto.UserRegDto;
import com.swpu.pipe.entity.Admin;
import com.swpu.pipe.entity.InputData;
import com.swpu.pipe.entity.User;
import com.swpu.pipe.util.FileUtil;
import com.swpu.pipe.util.PipeUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	private final int pageSize = 5;
	private final String command = "cmd /c start C://Users//Administrator//Desktop//editFile.bat";
	private final String filePath = "";
	private final String newFilePath = "";
	@Autowired
	private UserService userService;
	@Autowired
	private DataService datarService;
	@Autowired
	private AdminService adminService;

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
			
			User userTemp = userLonDto.toUser(userLonDto);
			if (userService.login(userTemp)) {
				
				request.getSession().setAttribute("username", userTemp.getUsername());
				User user = userService.findByUsername(userTemp.getUsername());
				model.addAttribute("user", user);
				return "profile";
			} 
			Admin admin = new Admin();
			admin.setAdminId(1);
			admin.setAdminName(userLonDto.getUsername());
			admin.setPassword(userLonDto.getPassword());
			if (adminService.verifyAdmin(admin)) {
				model.addAttribute("admin", admin);
				PageBean<User> pageBean = userService.findAll(1,pageSize);
				model.addAttribute("pageBean", pageBean);
				return "adminInterface";
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
	@GetMapping(value="/logout")
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
		if (userRegDto.getPassword().equals(userRegDto.getRePassword())) {
			
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
	@PostMapping(value="/infoChange")
	public String infoChange(UserInfoChangeDto userInfoChangeDto,Errors errors,MultipartFile photo, Model model,HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		if (!errors.hasErrors()) {
			String username = (String) request.getSession().getAttribute("username");
			ServletContext context = request.getServletContext();
			String path = context.getRealPath("/images");
			System.out.println(photo);
			String fileName = PipeUtil.getRandomFileName(photo.getOriginalFilename());
			photo.transferTo(new File(path + "/" + fileName));
			User userTemp = userInfoChangeDto.toUser(userInfoChangeDto);
			userTemp.setUsername(username);
			userTemp.setPhoto(fileName);
			if (userService.updateUser(userTemp)) {
				User user = userService.findByUsername(username);
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
	
	@RequestMapping(value="/showUser")
	public String showUser(Integer page, Model model){
		if (page != null) {
			PageBean<User> pageBean = userService.findAll(page, pageSize);
			model.addAttribute("pageBean", pageBean);
			//model.addAttribute("qStr", id);
			return "adminInterface";
		} else {
			PageBean<User> pageBean = userService.findAll(1, pageSize);	
			model.addAttribute("pageBean", pageBean);
			//model.addAttribute("qStr", id);
			return "adminInterface";
		}
		
	}
	@RequestMapping(value="/deleteUser")
	public String deleteUser(String userName, Model model){
		User user = userService.findByUsername(userName);
		if (userService.delete(user)) {
			PageBean<User> pageBean = userService.findAll(1, pageSize);	
			model.addAttribute("pageBean", pageBean);
			model.addAttribute("hint", "删除成功！！");
			return "adminInterface";
		}
		PageBean<User> pageBean = userService.findAll(1, pageSize);	
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("hint", "删除失败！！");
		return "adminInterface";
	}
	
	@GetMapping(value="/toIndex")
	public String toIndex(HttpServletRequest request, HttpServletResponse response,Model model){
		String username = (String) request.getSession().getAttribute("username");
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "index";
	}
	@GetMapping(value="/toResult")
	public String toResult(HttpServletRequest request, HttpServletResponse response,Model model){
		String username = (String) request.getSession().getAttribute("username");
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "result";
	}
	@GetMapping(value="/toQuery")
	public String toQuery(HttpServletRequest request, HttpServletResponse response,Model model){
		String username = (String) request.getSession().getAttribute("username");
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "query";
	}
	@GetMapping(value="/toAnsys")
	public String toAnsys(HttpServletRequest request, HttpServletResponse response,Model model){
		String username = (String) request.getSession().getAttribute("username");
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "ansys";
	}
	@GetMapping(value="/toBlank")
	public String toBlank(HttpServletRequest request, HttpServletResponse response,Model model){
		String username = (String) request.getSession().getAttribute("username");
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "blank";
	}
	
	@GetMapping(value="/editPass")
	public String toEditPass(HttpServletRequest request, HttpServletResponse response,Model model){
		String username = (String) request.getSession().getAttribute("username");
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "editPass";
	}
	
	/**
	 * 修改密码的controller
	 * @param userEditPassDto
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(value="/updatePass")
	public String toUpdatePass(UserEditPassDto userEditPassDto,Model model,HttpServletRequest request, HttpServletResponse response){
		if (userEditPassDto.getPassword().equals(userEditPassDto.getRePassword())) {
			if (userService.updatePassword(userEditPassDto)) {
				String username = (String) request.getSession().getAttribute("username");
				User user = userService.findByUsername(username);
				model.addAttribute("user", user);
				model.addAttribute("hint", "修改密码成功");
				return "editPass";
			}else{
				String username = (String) request.getSession().getAttribute("username");
				User user = userService.findByUsername(username);
				model.addAttribute("user", user);
				model.addAttribute("hint", "修改密码失败");
				return "editPass";
			}
		}else{
			String username = (String) request.getSession().getAttribute("username");
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
			model.addAttribute("hint", "两次输入密码不一致，请重新输入");
			return "editPass";
		}

		
	}
	/**
	 * 计算结果展示
	 * @param model
	 * @return
	 */
	@RequestMapping(value="testJson", method=RequestMethod.GET)
	public String sendData(Model model){
		List<Integer> list1 = new ArrayList<>();
		list1.add(15);
		list1.add(25);
		list1.add(10);
		List<Integer> list2 = new ArrayList<>();
		list2.add(25);
		list2.add(35);
		list2.add(20);
		Map<String,List<Integer>> map = new HashMap<>();
		map.put("first", list1);
		map.put("second", list2);
		model.addAttribute("map", map);
		return "result";
	}
	
	// 数据交互时候的重要的controller。
	// 计算的controller
	@PostMapping(value="/compute")
	public String compute(InputData inputData,HttpServletRequest request, HttpServletResponse response,Model model){		
		String username = (String) request.getSession().getAttribute("username");
		User user = userService.findByUsername(username);
		inputData.setUser(user);
		List<String> oldList = new ArrayList<>();
		oldList.add("");
		List<String> newList = new ArrayList<>();
		newList.add(inputData.getTypeOfCrack().toString());
		if (datarService.saveData(inputData)) {
			FileUtil.createScriptFile(command, filePath, newFilePath, oldList, newList);
		}
		return null;	
	}
	
	@GetMapping(value="/ansysFactor")
	public String ansysFactor(@RequestParam(value = "param") String param ,Model model,HttpServletRequest request, HttpServletResponse response){
		System.out.println(param);
		int newParam = Integer.parseInt(param);
		model.addAttribute("param1", newParam);
		String username = (String) request.getSession().getAttribute("username");
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "ansys";
	}

//	/**
//		 * form表单提交 Date类型数据绑定
//		 * <功能详细描述>
//		 * @param binder
//		 * @see [类、类#方法、类#成员]
//		 */
//	@InitBinder  
//	public void initBinder(WebDataBinder binder) {  
//		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
//		    dateFormat.setLenient(false);  
//		    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
//	}


	
}
