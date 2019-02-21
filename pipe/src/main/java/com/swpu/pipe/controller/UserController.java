package com.swpu.pipe.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.Query;
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
import com.swpu.pipe.dto.DataShowDto;
import com.swpu.pipe.dto.InputDataDto;
import com.swpu.pipe.dto.QueryData;
import com.swpu.pipe.dto.UserEditPassDto;
import com.swpu.pipe.dto.UserInfoChangeDto;
import com.swpu.pipe.dto.UserLonDto;
import com.swpu.pipe.dto.UserRegDto;
import com.swpu.pipe.entity.Admin;
import com.swpu.pipe.entity.InputData;
import com.swpu.pipe.entity.ResultData;
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
	private DataService dataService;
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
	@RequestMapping(value="/testJson", method=RequestMethod.GET)
	public String sendData(Model model,HttpServletRequest request, HttpServletResponse response){
		ResultData resultData = dataService.selectNewResultData();
		List<String> list = new ArrayList<>();
		list.add(resultData.getCrackJs());
		list.add(resultData.getCrackMises());
		list.add(resultData.getAxialMises());
		list.add(resultData.getAxialU2());
		list.add(resultData.getAxialPressure());
		list.add(resultData.getAxialShear());
		// 纵坐标的数值。
		DataShowDto dataShowDto =  FileUtil.StringToArray(list);
		
		
		List<String> list1 = new ArrayList<>();
		list1.add("0");list1.add("15");list1.add("30");list1.add("45");list1.add("60");list1.add("75");list1.add("90");
//		for (int i = 1; i < dataShowDto.getCrackJs().size()+1; i++) {
//			list1.add(String.valueOf(i));
//		}
		List<String> list2 = new ArrayList<>();
		list2.add("0");list2.add("15");list2.add("30");list2.add("45");list2.add("60");list2.add("75");list2.add("90");
//		for (int i = 1; i < dataShowDto.getCrackMises().size()+1; i++) {
//			list2.add(String.valueOf(i));
//		}
		List<String> list3 = new ArrayList<>();
		list3.add("0");list3.add("0.6");list3.add("1.2");list3.add("1.8");
		list3.add("2.4");list3.add("3");list3.add("3.6");list3.add("4.2");
		list3.add("4.8");list3.add("5.4");list3.add("6");list3.add("6.6");
		list3.add("7.2");list3.add("7.9");list3.add("8.5");list3.add("9.15");
		list3.add("9.75");list3.add("10.35");list3.add("10.95");list3.add("11.55");
		list3.add("12.15");list3.add("12.75");list3.add("13.35");list3.add("13.95");
		list3.add("14.45");list3.add("15.15");list3.add("15.75");list3.add("16.35");
		list3.add("16.95");list3.add("17.75");list3.add("18.15");list3.add("18.75");
		list3.add("19.35");list3.add("19.95");list3.add("20.55");list3.add("21.15");
		list3.add("21.77");list3.add("22.38");list3.add("23");list3.add("23.6");
		list3.add("24.2");list3.add("24.8");list3.add("24.985");list3.add("24.989");
		list3.add("24.993");list3.add("24.997");list3.add("25");
//		for (int i = 1; i < dataShowDto.getAxialMises().size()+1; i++) {
//			list3.add(String.valueOf(i));
//		}
		List<String> list4 = new ArrayList<>();
		list4.add("0");list4.add("0.6");list4.add("1.2");list4.add("1.8");
		list4.add("2.4");list4.add("3");list4.add("3.6");list4.add("4.2");
		list4.add("4.8");list4.add("5.4");list4.add("6");list4.add("6.6");
		list4.add("7.2");list4.add("7.9");list4.add("8.5");list4.add("9.15");
		list4.add("9.75");list4.add("10.35");list4.add("10.95");list4.add("11.55");
		list4.add("12.15");list4.add("12.75");list4.add("13.35");list4.add("13.95");
		list4.add("14.45");list4.add("15.15");list4.add("15.75");list4.add("16.35");
		list4.add("16.95");list4.add("17.75");list4.add("18.15");list4.add("18.75");
		list4.add("19.35");list4.add("19.95");list4.add("20.55");list4.add("21.15");
		list4.add("21.77");list4.add("22.38");list4.add("23");list4.add("23.6");
		list4.add("24.2");list4.add("24.8");list4.add("24.985");list4.add("24.989");
		list4.add("24.993");list4.add("24.997");list4.add("25");
//		for (int i = 1; i < dataShowDto.getAxialUs().size()+1; i++) {
//			list4.add(String.valueOf(i));
//		}
		List<String> list5 = new ArrayList<>();
		list5.add("0");list5.add("0.6");list5.add("1.2");list5.add("1.8");
		list5.add("2.4");list5.add("3");list5.add("3.6");list5.add("4.2");
		list5.add("4.8");list5.add("5.4");list5.add("6");list5.add("6.6");
		list5.add("7.2");list5.add("7.9");list5.add("8.5");list5.add("9.15");
		list5.add("9.75");list5.add("10.35");list5.add("10.95");list5.add("11.55");
		list5.add("12.15");list5.add("12.75");list5.add("13.35");list5.add("13.95");
		list5.add("14.45");list5.add("15.15");list5.add("15.75");list5.add("16.35");
		list5.add("16.95");list5.add("17.75");list5.add("18.15");list5.add("18.75");
		list5.add("19.35");list5.add("19.95");list5.add("20.55");list5.add("21.15");
		list5.add("21.77");list5.add("22.38");list5.add("23");list5.add("23.6");
		list5.add("24.2");list5.add("24.8");list5.add("24.985");list5.add("24.989");
		list5.add("24.993");list5.add("24.997");list5.add("25");
//		for (int i = 1; i < dataShowDto.getAxialPressure().size()+1; i++) {
//			list5.add(String.valueOf(i));
//		}
		List<String> list6 = new ArrayList<>();
		list6.add("0");list6.add("0.6");list6.add("1.2");list6.add("1.8");
		list6.add("2.4");list6.add("3");list6.add("3.6");list6.add("4.2");
		list6.add("4.8");list6.add("5.4");list6.add("6");list6.add("6.6");
		list6.add("7.2");list6.add("7.9");list6.add("8.5");list6.add("9.15");
		list6.add("9.75");list6.add("10.35");list6.add("10.95");list6.add("11.55");
		list6.add("12.15");list6.add("12.75");list6.add("13.35");list6.add("13.95");
		list6.add("14.45");list6.add("15.15");list6.add("15.75");list6.add("16.35");
		list6.add("16.95");list6.add("17.75");list6.add("18.15");list6.add("18.75");
		list6.add("19.35");list6.add("19.95");list6.add("20.55");list6.add("21.15");
		list6.add("21.77");list6.add("22.38");list6.add("23");list6.add("23.6");
		list6.add("24.2");list6.add("24.8");list6.add("24.985");list6.add("24.989");
		list6.add("24.993");list6.add("24.997");list6.add("25");
//		for (int i = 1; i < dataShowDto.getAxialShear().size()+1; i++) {
//			list6.add(String.valueOf(i));
//		}	
		
//		Map<String,List<String>> map= new HashMap<>();
		Map<String,List<String>> mapCrackJs = new HashMap<>();
		Map<String,List<String>> mapCrackMises = new HashMap<>();
		Map<String,List<String>> mapAxialMises = new HashMap<>();
		Map<String,List<String>> mapAxialU2 = new HashMap<>();
		Map<String,List<String>> mapAxialPressure = new HashMap<>();
		Map<String,List<String>> mapAxialShear = new HashMap<>();
		mapCrackJs.put("X", list1);
		mapCrackJs.put("Y", dataShowDto.getCrackJs());
		model.addAttribute("mapCrackJs", mapCrackJs);
		
		mapCrackMises.put("X", list2);
		mapCrackMises.put("Y", dataShowDto.getCrackMises());
		model.addAttribute("mapCrackMises", mapCrackMises);	
		
		mapAxialMises.put("X", list3);
		mapAxialMises.put("Y", dataShowDto.getAxialMises());
		model.addAttribute("mapAxialMises", mapAxialMises);
		
		mapAxialU2.put("X", list4);
		mapAxialU2.put("Y", dataShowDto.getAxialUs());
		model.addAttribute("mapAxialU2", mapAxialU2);
		
		mapAxialPressure.put("X", list5);
		mapAxialPressure.put("Y", dataShowDto.getAxialPressure());
		model.addAttribute("mapAxialPressure", mapAxialPressure);
		
		mapAxialShear.put("X", list6);
		mapAxialShear.put("Y", dataShowDto.getAxialShear());
		model.addAttribute("mapAxialShear", mapAxialShear);
		model.addAttribute("temp", "导出结果数据");
		String username = (String) request.getSession().getAttribute("username");
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "result";	
	}
	
	// 数据交互时候的重要的controller。
	// 计算的controller
	@PostMapping(value="/compute")
	public String compute(InputData inputData,HttpServletRequest request, HttpServletResponse response,Model model){		
		String username = (String) request.getSession().getAttribute("username");
		User user = userService.findByUsername(username);
		inputData.setUser(user);		
//		List<String> oldList = new ArrayList<>();
//		oldList.add("");
//		List<String> newList = new ArrayList<>();
//		newList.add(inputData.getTypeOfCrack().toString());
		if (dataService.selectInputData(inputData) != null) {
			model.addAttribute("message", "请勿重复计算！！");
			model.addAttribute("user", user);
			return "index";
		}
		
		// 调用bat运行py程序  
		String commandCompute="cmd /c start C://Users//Administrator//Desktop//Run_pipe.bat";
		try {
			Runtime.getRuntime().exec(commandCompute);
			
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		String commandComputeInp="cmd /c start C://Users//Administrator//Desktop//Run_inp.bat";
		try {
			Runtime.getRuntime().exec(commandComputeInp);
			
			Thread.sleep(25000);
		} catch (Exception e) {
			// TODO: handle exception
		}		
		
		if (dataService.saveData(inputData)) {
		     String commandU2 = "cmd /c start C://Users//Administrator//Desktop//readU2.bat";
		     String commandMises = "cmd /c start  C://Users//Administrator//Desktop//readMises.bat";
		     String commandU3 = "cmd /c start C://Users//Administrator//Desktop//readSS3.bat";
		     String commandShear = "cmd /c start C://Users//Administrator//Desktop//readShear.bat";
		     String commandcrackMises = "cmd /c start C://Users//Administrator//Desktop//readcrackMises.bat";
		     String commandcrackJs = "cmd /c start C://Users//Administrator//Desktop//readcrackJs.bat";
		        try { 
		            Runtime.getRuntime().exec(commandU2);
		            Runtime.getRuntime().exec(commandMises);
		            Runtime.getRuntime().exec(commandU3);
		            Runtime.getRuntime().exec(commandShear);
		            Runtime.getRuntime().exec(commandcrackMises);
		            Runtime.getRuntime().exec(commandcrackJs);
		        } catch (IOException e) {
		            e.printStackTrace();
			}
			//FileUtil.createScriptFile(command, filePath, newFilePath, oldList, newList);
		    ResultData resultData = new ResultData();
		    try {
		    	Thread.sleep(2000);  //休眠一分钟
		    	} catch (InterruptedException e) {
		    	e.printStackTrace();
		    	} 		    		    
//			List<String> list_dataCrackJs = FileUtil.read("E:\\yinSoft\\AbaqusINP01\\dataCrackJs.txt");
//			List<String> list_dataCrackMises = FileUtil.read("E:\\yinSoft\\AbaqusINP01\\dataCrackMises.txt");
//			List<String> list_dataSS3 = FileUtil.read("E:\\yinSoft\\AbaqusINP01\\dataSS3.txt");
//			List<String> list_dataSS2 = FileUtil.read("E:\\yinSoft\\AbaqusINP01\\dataSS2.txt");
//			List<String> list_dataU2 = FileUtil.read("E:\\yinSoft\\AbaqusINP01\\dataU2.txt");
//			List<String> list_dataMises = FileUtil.read("E:\\yinSoft\\AbaqusINP01\\dataMises.txt");
			List<String> list_dataCrackJs = FileUtil.read("E:\\yinSoft\\test\\dataCrackJs.txt");
			List<String> list_dataCrackMises = FileUtil.read("E:\\yinSoft\\test\\dataCrackMises.txt");
			List<String> list_dataSS3 = FileUtil.read("E:\\yinSoft\\test\\dataSS3.txt");
			List<String> list_dataSS2 = FileUtil.read("E:\\yinSoft\\test\\dataSS2.txt");
			List<String> list_dataU2 = FileUtil.read("E:\\yinSoft\\test\\dataU2.txt");
			List<String> list_dataMises = FileUtil.read("E:\\yinSoft\\test\\dataMises.txt");
			resultData.setAxialU2(list_dataU2.toString());
			resultData.setAxialMises(list_dataMises.toString());
			resultData.setAxialShear(list_dataSS2.toString());
			resultData.setAxialPressure(list_dataSS3.toString());
			resultData.setCrackJs(list_dataCrackJs.toString());
			resultData.setCrackMises(list_dataCrackMises.toString());
			resultData.setUser(user);
			resultData.setInputData(inputData);
			if (dataService.saveResultData(resultData)) {
				List<String> list_mess = FileUtil.read("E:\\yinSoft\\AbaqusINP01\\mess.log");
				String message = list_mess.get(list_mess.size()-1);
				model.addAttribute("message", message);
				model.addAttribute("temp", "计算成功,查看计算结果");
				model.addAttribute("user", user);
			}
			return "index";				
		}
		return "index";	
	}
	
	@RequestMapping(value="/query")	
	public String query(QueryData queryData, Model model,HttpServletRequest request, HttpServletResponse response){
		ResultData resultData = dataService.showData(queryData);
		if (resultData==null) {
			request.getSession().setAttribute("mess", "查询数据失败，请重新输入查询数据！！");
			String username = (String) request.getSession().getAttribute("username");
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
			return "query";
		}
		List<String> list = new ArrayList<>();
		list.add(resultData.getCrackJs());
		list.add(resultData.getCrackMises());
		list.add(resultData.getAxialMises());
		list.add(resultData.getAxialU2());
		list.add(resultData.getAxialPressure());
		list.add(resultData.getAxialShear());
		// 纵坐标的数值。
		DataShowDto dataShowDto =  FileUtil.StringToArray(list);
		
		
		
		List<String> list1 = new ArrayList<>();
		list1.add("0");list1.add("15");list1.add("30");list1.add("45");list1.add("60");list1.add("75");list1.add("90");
//		for (int i = 1; i < dataShowDto.getCrackJs().size()+1; i++) {
//			list1.add(String.valueOf(i));
//		}
		List<String> list2 = new ArrayList<>();
		list2.add("0");list2.add("15");list2.add("30");list2.add("45");list2.add("60");list2.add("75");list2.add("90");
//		for (int i = 1; i < dataShowDto.getCrackMises().size()+1; i++) {
//			list2.add(String.valueOf(i));
//		}
		List<String> list3 = new ArrayList<>();
		list3.add("0");list3.add("0.6");list3.add("1.2");list3.add("1.8");
		list3.add("2.4");list3.add("3");list3.add("3.6");list3.add("4.2");
		list3.add("4.8");list3.add("5.4");list3.add("6");list3.add("6.6");
		list3.add("7.2");list3.add("7.9");list3.add("8.5");list3.add("9.15");
		list3.add("9.75");list3.add("10.35");list3.add("10.95");list3.add("11.55");
		list3.add("12.15");list3.add("12.75");list3.add("13.35");list3.add("13.95");
		list3.add("14.45");list3.add("15.15");list3.add("15.75");list3.add("16.35");
		list3.add("16.95");list3.add("17.75");list3.add("18.15");list3.add("18.75");
		list3.add("19.35");list3.add("19.95");list3.add("20.55");list3.add("21.15");
		list3.add("21.77");list3.add("22.38");list3.add("23");list3.add("23.6");
		list3.add("24.2");list3.add("24.8");list3.add("24.985");list3.add("24.989");
		list3.add("24.993");list3.add("24.997");list3.add("25");
//		for (int i = 1; i < dataShowDto.getAxialMises().size()+1; i++) {
//			list3.add(String.valueOf(i));
//		}
		List<String> list4 = new ArrayList<>();
		list4.add("0");list4.add("0.6");list4.add("1.2");list4.add("1.8");
		list4.add("2.4");list4.add("3");list4.add("3.6");list4.add("4.2");
		list4.add("4.8");list4.add("5.4");list4.add("6");list4.add("6.6");
		list4.add("7.2");list4.add("7.9");list4.add("8.5");list4.add("9.15");
		list4.add("9.75");list4.add("10.35");list4.add("10.95");list4.add("11.55");
		list4.add("12.15");list4.add("12.75");list4.add("13.35");list4.add("13.95");
		list4.add("14.45");list4.add("15.15");list4.add("15.75");list4.add("16.35");
		list4.add("16.95");list4.add("17.75");list4.add("18.15");list4.add("18.75");
		list4.add("19.35");list4.add("19.95");list4.add("20.55");list4.add("21.15");
		list4.add("21.77");list4.add("22.38");list4.add("23");list4.add("23.6");
		list4.add("24.2");list4.add("24.8");list4.add("24.985");list4.add("24.989");
		list4.add("24.993");list4.add("24.997");list4.add("25");
//		for (int i = 1; i < dataShowDto.getAxialUs().size()+1; i++) {
//			list4.add(String.valueOf(i));
//		}
		List<String> list5 = new ArrayList<>();
		list5.add("0");list5.add("0.6");list5.add("1.2");list5.add("1.8");
		list5.add("2.4");list5.add("3");list5.add("3.6");list5.add("4.2");
		list5.add("4.8");list5.add("5.4");list5.add("6");list5.add("6.6");
		list5.add("7.2");list5.add("7.9");list5.add("8.5");list5.add("9.15");
		list5.add("9.75");list5.add("10.35");list5.add("10.95");list5.add("11.55");
		list5.add("12.15");list5.add("12.75");list5.add("13.35");list5.add("13.95");
		list5.add("14.45");list5.add("15.15");list5.add("15.75");list5.add("16.35");
		list5.add("16.95");list5.add("17.75");list5.add("18.15");list5.add("18.75");
		list5.add("19.35");list5.add("19.95");list5.add("20.55");list5.add("21.15");
		list5.add("21.77");list5.add("22.38");list5.add("23");list5.add("23.6");
		list5.add("24.2");list5.add("24.8");list5.add("24.985");list5.add("24.989");
		list5.add("24.993");list5.add("24.997");list5.add("25");
//		for (int i = 1; i < dataShowDto.getAxialPressure().size()+1; i++) {
//			list5.add(String.valueOf(i));
//		}
		List<String> list6 = new ArrayList<>();
		list6.add("0");list6.add("0.6");list6.add("1.2");list6.add("1.8");
		list6.add("2.4");list6.add("3");list6.add("3.6");list6.add("4.2");
		list6.add("4.8");list6.add("5.4");list6.add("6");list6.add("6.6");
		list6.add("7.2");list6.add("7.9");list6.add("8.5");list6.add("9.15");
		list6.add("9.75");list6.add("10.35");list6.add("10.95");list6.add("11.55");
		list6.add("12.15");list6.add("12.75");list6.add("13.35");list6.add("13.95");
		list6.add("14.45");list6.add("15.15");list6.add("15.75");list6.add("16.35");
		list6.add("16.95");list6.add("17.75");list6.add("18.15");list6.add("18.75");
		list6.add("19.35");list6.add("19.95");list6.add("20.55");list6.add("21.15");
		list6.add("21.77");list6.add("22.38");list6.add("23");list6.add("23.6");
		list6.add("24.2");list6.add("24.8");list6.add("24.985");list6.add("24.989");
		list6.add("24.993");list6.add("24.997");list6.add("25");
//		for (int i = 1; i < dataShowDto.getAxialShear().size()+1; i++) {
//			list6.add(String.valueOf(i));
//		}		
		
//		Map<String,List<String>> map= new HashMap<>();
		Map<String,List<String>> mapCrackJs = new HashMap<>();
		Map<String,List<String>> mapCrackMises = new HashMap<>();
		Map<String,List<String>> mapAxialMises = new HashMap<>();
		Map<String,List<String>> mapAxialU2 = new HashMap<>();
		Map<String,List<String>> mapAxialPressure = new HashMap<>();
		Map<String,List<String>> mapAxialShear = new HashMap<>();
		mapCrackJs.put("X", list1);
		mapCrackJs.put("Y", dataShowDto.getCrackJs());
		model.addAttribute("mapCrackJs", mapCrackJs);
		
		mapCrackMises.put("X", list2);
		mapCrackMises.put("Y", dataShowDto.getCrackMises());
		model.addAttribute("mapCrackMises", mapCrackMises);	
		
		mapAxialMises.put("X", list3);
		mapAxialMises.put("Y", dataShowDto.getAxialMises());
 		model.addAttribute("mapAxialMises", mapAxialMises);
		
		mapAxialU2.put("X", list4);
		mapAxialU2.put("Y", dataShowDto.getAxialUs());
		model.addAttribute("mapAxialU2", mapAxialU2);
		
		mapAxialPressure.put("X", list5);
		mapAxialPressure.put("Y", dataShowDto.getAxialPressure());
		model.addAttribute("mapAxialPressure", mapAxialPressure);
		
		mapAxialShear.put("X", list6);
		mapAxialShear.put("Y", dataShowDto.getAxialShear());
		model.addAttribute("mapAxialShear", mapAxialShear);
		
		model.addAttribute("temp", "删除数据");
		
		
		// 导出数据的操作
		FileWriter fw1 = null;  
		FileWriter fw2 = null;
		FileWriter fw3 = null;
		FileWriter fw4 = null;
		FileWriter fw5 = null; 
		FileWriter fw6 = null; 
		File fileCrackJs = new File("E:\\yinSoft\\exportQueryTXT\\getCrackJs.txt");  
		File fileCrackMises = new File("E:\\yinSoft\\exportQueryTXT\\getCrackMises.txt"); 
		File fileAxialMises = new File("E:\\yinSoft\\exportQueryTXT\\getAxialMises.txt"); 
		File fileAxialU2 = new File("E:\\yinSoft\\exportQueryTXT\\getAxialU2.txt"); 
		File fileAxialPressure = new File("E:\\yinSoft\\exportQueryTXT\\getAxialPressure.txt"); 
		File fileAxialShear = new File("E:\\yinSoft\\exportQueryTXT\\getAxialShear.txt");		
		
		try {           
	           
			 fw1 = new FileWriter(fileCrackJs);  
			 fw2 = new FileWriter(fileCrackMises); 
			 fw3 = new FileWriter(fileAxialMises); 
			 fw4 = new FileWriter(fileAxialU2); 
			 fw5 = new FileWriter(fileAxialPressure); 
			 fw6 = new FileWriter(fileAxialShear); 
			          
			fw1.write("index:"+list1+"\r\n");//向文件中写内容          
			//System.out.println(list1);
			fw1.write("data:"+dataShowDto.getCrackJs()+"\r\n");          
			fw1.flush();
			fw2.write("index:"+list2+"\r\n");//向文件中写内容          
			fw2.write("data:"+dataShowDto.getCrackMises()+"\r\n");          
			fw2.flush(); 
			fw3.write("index:"+list3+"\r\n");//向文件中写内容          
			fw3.write("data:"+dataShowDto.getAxialMises()+"\r\n");          
			fw3.flush(); 
			fw4.write("index:"+list4+"\r\n");//向文件中写内容          
			fw4.write("data:"+dataShowDto.getAxialUs()+"\r\n");          
			fw4.flush(); 
			fw5.write("index:"+list5+"\r\n");//向文件中写内容          
			fw5.write("data:"+dataShowDto.getAxialPressure()+"\r\n");          
			fw5.flush(); 
			fw6.write("index:"+list6+"\r\n");//向文件中写内容          
			fw6.write("data:"+dataShowDto.getAxialShear()+"\r\n");          
			fw6.flush(); 			
			//model.addAttribute("temp","删除数据");          
			//System.out.println("写数据成功！");       
			} catch (IOException e) {         
				  // TODO Auto-generated catch block          
				 e.printStackTrace();        }
			finally{          
				 if(fw1 != null){               
				 try {                   
					 fw1.close();              
			} 				 
				 catch (IOException e) { 
				             // TODO Auto-generated catch block                  
				 e.printStackTrace();              
				}           
			} 
			if(fw2 != null){               
				 try {                   
					 fw2.close();              
			} 				 
				 catch (IOException e) { 
				             // TODO Auto-generated catch block                  
				 e.printStackTrace();              
				}           
			}
			 if(fw3 != null){               
			 try {                   
				 fw3.close();              
		} 				 
			 catch (IOException e) { 
			             // TODO Auto-generated catch block                  
			 e.printStackTrace();              
			}           
		} 
		 if(fw4 != null){               
			 try {                   
				 fw4.close();              
		} 				 
			 catch (IOException e) { 
			             // TODO Auto-generated catch block                  
			 e.printStackTrace();              
			}           
		} 
		 if(fw5 != null){               
		 try {                   
			 fw5.close();              
	} 				 
		 catch (IOException e) { 
		             // TODO Auto-generated catch block                  
		 e.printStackTrace();              
		}           
	}
	 if(fw6 != null){               
		 try {                   
			 fw6.close();              
	} 				 
		 catch (IOException e) { 
		             // TODO Auto-generated catch block                  
		 e.printStackTrace();              
		}           
	} 
				 
		 }	
		request.getSession().setAttribute("mess", "查询成功！！");
		request.getSession().setAttribute("resultId", resultData.getResultDataId());
		String username = (String) request.getSession().getAttribute("username");
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "query";
	}
	
	
	@RequestMapping(value="/ansysData", method=RequestMethod.POST)
	public String ansys(String param ,QueryData queryData, Model model,HttpServletRequest request, HttpServletResponse response){
		List<ResultData> resultDatas = dataService.ansysData(queryData, param);
		List<DataShowDto> list = new ArrayList<>();
		for (int i = 0; i < resultDatas.size(); i++) {
			List<String> list1 = new ArrayList<>();
 			list1.add(resultDatas.get(i).getCrackJs());
			list1.add(resultDatas.get(i).getCrackMises());
			list1.add(resultDatas.get(i).getAxialMises());
			list1.add(resultDatas.get(i).getAxialU2());
			list1.add(resultDatas.get(i).getAxialPressure());
			list1.add(resultDatas.get(i).getAxialShear());
			DataShowDto dataShowDto =  FileUtil.StringToArray(list1);
			list.add(dataShowDto);
		}
		List<String> list1 = new ArrayList<>();
		for (int i = 1; i < list.get(0).getCrackJs().size()+1; i++) {
			list1.add(String.valueOf(i));
		}
		List<String> list2 = new ArrayList<>();
		for (int i = 1; i < list.get(0).getCrackMises().size()+1; i++) {
			list2.add(String.valueOf(i));
		}
		List<String> list3 = new ArrayList<>();
		for (int i = 1; i < list.get(0).getAxialMises().size()+1; i++) {
			list3.add(String.valueOf(i));
		}
		List<String> list4 = new ArrayList<>();
		for (int i = 1; i < list.get(0).getAxialUs().size()+1; i++) {
			list4.add(String.valueOf(i));
		}
		List<String> list5 = new ArrayList<>();
		for (int i = 1; i < list.get(0).getAxialPressure().size()+1; i++) {
			list5.add(String.valueOf(i));
		}
		List<String> list6 = new ArrayList<>();
		for (int i = 1; i < list.get(0).getAxialShear().size()+1; i++) {
			list6.add(String.valueOf(i));
		}		
		
		List<List<String>> newlist1 = new ArrayList<>();
		List<List<String>> listCrackJs = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			listCrackJs.add(list.get(i).getCrackJs());
			newlist1.add(list1);
		}
		List<List<String>> newlist2 = new ArrayList<>();
		List<List<String>> listCrackMises = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			listCrackMises.add(list.get(i).getCrackMises());
			newlist2.add(list2);
		}
		List<List<String>> newlist3 = new ArrayList<>();
		List<List<String>> listAxialMises = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			listAxialMises.add(list.get(i).getAxialMises());
			newlist3.add(list3);
		}
		List<List<String>> newlist4 = new ArrayList<>();
		List<List<String>> listAxialU2 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			listAxialU2.add(list.get(i).getAxialUs());
			newlist4.add(list4);
		}
		List<List<String>> newlist5 = new ArrayList<>();
		List<List<String>> listAxialPressure = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			listAxialPressure.add(list.get(i).getAxialPressure());
			newlist5.add(list5);
		}
		List<List<String>> newlist6 = new ArrayList<>();
		List<List<String>> listAxialShear = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			listAxialShear.add(list.get(i).getAxialShear());
			newlist6.add(list6);
		}
		
		
		Map<String,List<List<String>>> mapCrackJs  = new HashMap<>();
		Map<String,List<List<String>>> mapCrackMises = new HashMap<>();
		Map<String,List<List<String>>> mapAxialMises = new HashMap<>();
		Map<String,List<List<String>>> mapAxialU2 = new HashMap<>();
		Map<String,List<List<String>>> mapAxialPressure = new HashMap<>();
		Map<String,List<List<String>>> mapAxialShear = new HashMap<>();
		mapCrackJs.put("X", newlist1);
		mapCrackJs.put("Y", listCrackJs);
		model.addAttribute("mapCrackJs", mapCrackJs);
		model.addAttribute("Xlist1", newlist1.get(0));
		
		mapCrackMises.put("X", newlist2);
		mapCrackMises.put("Y", listCrackMises);
		model.addAttribute("mapCrackMises", mapCrackMises);	
		model.addAttribute("Xlist2", newlist2.get(0));
		
		mapAxialMises.put("X", newlist3);
		mapAxialMises.put("Y", listAxialMises);
 		model.addAttribute("mapAxialMises", mapAxialMises);
 		model.addAttribute("Xlist3", newlist3.get(0));
 		
		mapAxialU2.put("X", newlist4);
		mapAxialU2.put("Y", listAxialU2);
		model.addAttribute("mapAxialU2", mapAxialU2);
		model.addAttribute("Xlist4", newlist4.get(0));
		
		mapAxialPressure.put("X", newlist5);
		mapAxialPressure.put("Y", listAxialPressure );
		model.addAttribute("mapAxialPressure", mapAxialPressure);
		model.addAttribute("Xlist5", newlist5.get(0));
		
		mapAxialShear.put("X", newlist6);
		mapAxialShear.put("Y", listAxialShear);
		model.addAttribute("mapAxialShear", mapAxialShear);		
		model.addAttribute("Xlist6", newlist6.get(0));
		
		return "ansys";

	}

	@GetMapping(value="/ansysFactor")
	public String ansysFactor(@RequestParam(value = "param") String param , Model model,HttpServletRequest request, HttpServletResponse response){
		
		int newParam = Integer.parseInt(param);
		model.addAttribute("param1", newParam);
		String username = (String) request.getSession().getAttribute("username");
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "ansys";
	}
	
	
	@RequestMapping(value="/exportComputeData", method=RequestMethod.GET)
	public String exportComputeData(Model model,HttpServletRequest request, HttpServletResponse respons){
		ResultData resultData = dataService.selectNewResultData();
		List<String> list = new ArrayList<>();
		list.add(resultData.getCrackJs());
		list.add(resultData.getCrackMises());
		list.add(resultData.getAxialMises());
		list.add(resultData.getAxialU2());
		list.add(resultData.getAxialPressure());
		list.add(resultData.getAxialShear());
		// 纵坐标的数值。
		DataShowDto dataShowDto =  FileUtil.StringToArray(list);
		
		
		
		List<String> list1 = new ArrayList<>();
		list1.add("0");list1.add("15");list1.add("30");list1.add("45");list1.add("60");list1.add("75");list1.add("90");
//		for (int i = 1; i < dataShowDto.getCrackJs().size()+1; i++) {
//			list1.add(String.valueOf(i));
//		}
		List<String> list2 = new ArrayList<>();
		list2.add("0");list2.add("15");list2.add("30");list2.add("45");list2.add("60");list2.add("75");list2.add("90");
//		for (int i = 1; i < dataShowDto.getCrackMises().size()+1; i++) {
//			list2.add(String.valueOf(i));
//		}
		List<String> list3 = new ArrayList<>();
		list3.add("0");list3.add("0.6");list3.add("1.2");list3.add("1.8");
		list3.add("2.4");list3.add("3");list3.add("3.6");list3.add("4.2");
		list3.add("4.8");list3.add("5.4");list3.add("6");list3.add("6.6");
		list3.add("7.2");list3.add("7.9");list3.add("8.5");list3.add("9.15");
		list3.add("9.75");list3.add("10.35");list3.add("10.95");list3.add("11.55");
		list3.add("12.15");list3.add("12.75");list3.add("13.35");list3.add("13.95");
		list3.add("14.45");list3.add("15.15");list3.add("15.75");list3.add("16.35");
		list3.add("16.95");list3.add("17.75");list3.add("18.15");list3.add("18.75");
		list3.add("19.35");list3.add("19.95");list3.add("20.55");list3.add("21.15");
		list3.add("21.77");list3.add("22.38");list3.add("23");list3.add("23.6");
		list3.add("24.2");list3.add("24.8");list3.add("24.985");list3.add("24.989");
		list3.add("24.993");list3.add("24.997");list3.add("25");
//		for (int i = 1; i < dataShowDto.getAxialMises().size()+1; i++) {
//			list3.add(String.valueOf(i));
//		}
		List<String> list4 = new ArrayList<>();
		list4.add("0");list4.add("0.6");list4.add("1.2");list4.add("1.8");
		list4.add("2.4");list4.add("3");list4.add("3.6");list4.add("4.2");
		list4.add("4.8");list4.add("5.4");list4.add("6");list4.add("6.6");
		list4.add("7.2");list4.add("7.9");list4.add("8.5");list4.add("9.15");
		list4.add("9.75");list4.add("10.35");list4.add("10.95");list4.add("11.55");
		list4.add("12.15");list4.add("12.75");list4.add("13.35");list4.add("13.95");
		list4.add("14.45");list4.add("15.15");list4.add("15.75");list4.add("16.35");
		list4.add("16.95");list4.add("17.75");list4.add("18.15");list4.add("18.75");
		list4.add("19.35");list4.add("19.95");list4.add("20.55");list4.add("21.15");
		list4.add("21.77");list4.add("22.38");list4.add("23");list4.add("23.6");
		list4.add("24.2");list4.add("24.8");list4.add("24.985");list4.add("24.989");
		list4.add("24.993");list4.add("24.997");list4.add("25");
//		for (int i = 1; i < dataShowDto.getAxialUs().size()+1; i++) {
//			list4.add(String.valueOf(i));
//		}
		List<String> list5 = new ArrayList<>();
		list5.add("0");list5.add("0.6");list5.add("1.2");list5.add("1.8");
		list5.add("2.4");list5.add("3");list5.add("3.6");list5.add("4.2");
		list5.add("4.8");list5.add("5.4");list5.add("6");list5.add("6.6");
		list5.add("7.2");list5.add("7.9");list5.add("8.5");list5.add("9.15");
		list5.add("9.75");list5.add("10.35");list5.add("10.95");list5.add("11.55");
		list5.add("12.15");list5.add("12.75");list5.add("13.35");list5.add("13.95");
		list5.add("14.45");list5.add("15.15");list5.add("15.75");list5.add("16.35");
		list5.add("16.95");list5.add("17.75");list5.add("18.15");list5.add("18.75");
		list5.add("19.35");list5.add("19.95");list5.add("20.55");list5.add("21.15");
		list5.add("21.77");list5.add("22.38");list5.add("23");list5.add("23.6");
		list5.add("24.2");list5.add("24.8");list5.add("24.985");list5.add("24.989");
		list5.add("24.993");list5.add("24.997");list5.add("25");
//		for (int i = 1; i < dataShowDto.getAxialPressure().size()+1; i++) {
//			list5.add(String.valueOf(i));
//		}
		List<String> list6 = new ArrayList<>();
		list6.add("0");list6.add("0.6");list6.add("1.2");list6.add("1.8");
		list6.add("2.4");list6.add("3");list6.add("3.6");list6.add("4.2");
		list6.add("4.8");list6.add("5.4");list6.add("6");list6.add("6.6");
		list6.add("7.2");list6.add("7.9");list6.add("8.5");list6.add("9.15");
		list6.add("9.75");list6.add("10.35");list6.add("10.95");list6.add("11.55");
		list6.add("12.15");list6.add("12.75");list6.add("13.35");list6.add("13.95");
		list6.add("14.45");list6.add("15.15");list6.add("15.75");list6.add("16.35");
		list6.add("16.95");list6.add("17.75");list6.add("18.15");list6.add("18.75");
		list6.add("19.35");list6.add("19.95");list6.add("20.55");list6.add("21.15");
		list6.add("21.77");list6.add("22.38");list6.add("23");list6.add("23.6");
		list6.add("24.2");list6.add("24.8");list6.add("24.985");list6.add("24.989");
		list6.add("24.993");list6.add("24.997");list6.add("25");	
			
			FileWriter fw1 = null;  
			FileWriter fw2 = null;
			FileWriter fw3 = null;
			FileWriter fw4 = null;
			FileWriter fw5 = null; 
			FileWriter fw6 = null; 
			File fileCrackJs = new File("E:\\yinSoft\\exportTXT\\getCrackJs.txt");  
			File fileCrackMises = new File("E:\\yinSoft\\exportTXT\\getCrackMises.txt"); 
			File fileAxialMises = new File("E:\\yinSoft\\exportTXT\\getAxialMises.txt"); 
			File fileAxialU2 = new File("E:\\yinSoft\\exportTXT\\getAxialU2.txt"); 
			File fileAxialPressure = new File("E:\\yinSoft\\exportTXT\\getAxialPressure.txt"); 
			File fileAxialShear = new File("E:\\yinSoft\\exportTXT\\getAxialShear.txt"); 
		
			try {           
		           
			 fw1 = new FileWriter(fileCrackJs);  
			 fw2 = new FileWriter(fileCrackMises); 
			 fw3 = new FileWriter(fileAxialMises); 
			 fw4 = new FileWriter(fileAxialU2); 
			 fw5 = new FileWriter(fileAxialPressure); 
			 fw6 = new FileWriter(fileAxialShear); 
			          
			fw1.write("index:"+list1+"\r\n");//向文件中写内容          
			fw1.write("data:"+dataShowDto.getCrackJs()+"\r\n");          
			fw1.flush();
			fw2.write("index:"+list2+"\r\n");//向文件中写内容          
			fw2.write("data:"+dataShowDto.getCrackMises()+"\r\n");          
			fw2.flush(); 
			fw3.write("index:"+list3+"\r\n");//向文件中写内容          
			fw3.write("data:"+dataShowDto.getAxialMises()+"\r\n");          
			fw3.flush(); 
			fw4.write("index:"+list4+"\r\n");//向文件中写内容          
			fw4.write("data:"+dataShowDto.getAxialUs()+"\r\n");          
			fw4.flush(); 
			fw5.write("index:"+list5+"\r\n");//向文件中写内容          
			fw5.write("data:"+dataShowDto.getAxialPressure()+"\r\n");          
			fw5.flush(); 
			fw6.write("index:"+list6+"\r\n");//向文件中写内容          
			fw6.write("data:"+dataShowDto.getAxialShear()+"\r\n");          
			fw6.flush(); 			
			model.addAttribute("temp","写数据成功！");          
			System.out.println("写数据成功！");       
			} catch (IOException e) {         
				  // TODO Auto-generated catch block          
				 e.printStackTrace();        }
			finally{          
				 if(fw1 != null){               
				 try {                   
					 fw1.close();              
			} 				 
				 catch (IOException e) { 
				             // TODO Auto-generated catch block                  
				 e.printStackTrace();              
				}           
			} 
			if(fw2 != null){               
				 try {                   
					 fw2.close();              
			} 				 
				 catch (IOException e) { 
				             // TODO Auto-generated catch block                  
				 e.printStackTrace();              
				}           
			}
			 if(fw3 != null){               
			 try {                   
				 fw3.close();              
		} 				 
			 catch (IOException e) { 
			             // TODO Auto-generated catch block                  
			 e.printStackTrace();              
			}           
		} 
		 if(fw4 != null){               
			 try {                   
				 fw4.close();              
		} 				 
			 catch (IOException e) { 
			             // TODO Auto-generated catch block                  
			 e.printStackTrace();              
			}           
		} 
		 if(fw5 != null){               
		 try {                   
			 fw5.close();              
	} 				 
		 catch (IOException e) { 
		             // TODO Auto-generated catch block                  
		 e.printStackTrace();              
		}           
	}
	 if(fw6 != null){               
		 try {                   
			 fw6.close();              
	} 				 
		 catch (IOException e) { 
		             // TODO Auto-generated catch block                  
		 e.printStackTrace();              
		}           
	} 
				 
		 }	
		String username = (String) request.getSession().getAttribute("username");
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "result";	
	}

	@GetMapping(value="deleteData")
	public String deleteData(Model model,HttpServletRequest request, HttpServletResponse response){
		int id = (int) request.getSession().getAttribute("resultId");
		String username = (String) request.getSession().getAttribute("username");
		User user = userService.findByUsername(username);
		
		if (dataService.deleteData(id)) {
			//model.addAttribute("temp", "删除数据成功！！");
			request.getSession().setAttribute("mess", "删除数据成功！！");
			model.addAttribute("user", user);
			return "query";
		}
		//model.addAttribute("temp", "删除数据失败！！");
		request.getSession().setAttribute("mess", "删除数据失败！！");
		model.addAttribute("user", user);
		return "query";
		
	}
	
}
