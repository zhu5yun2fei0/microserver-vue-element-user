package com.pktech.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pktech.bean.User;
import com.pktech.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public Map<String, Object> login(@RequestParam String phone,@RequestParam String password) {
		//String phone="13855201101";
		Map<String, Object> map=new HashMap<String, Object>();
		User user=userService.findByUsername(phone);
		if(user==null) {
			map.put("code", "0002");
			map.put("msg", "用户不存在");
			return map;
		}else if(user.getPassword().equals(password)){
			map.put("code", "0000");
			map.put("msg", "登陆成功");
			return map;
		}else {
			map.put("code", "0001");
			map.put("msg", "密码错误");
			return map;
		}
	}
	
	@RequestMapping(value="/regist",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@CrossOrigin
	public Map<String, Object> regist(@RequestBody User user){
		String id=UUID.randomUUID().toString();
		user.setId(id);
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			userService.saveUser(user);
			map.put("msg", "注册成功");
			map.put("code", "0000");
		} catch (Exception e) {
			map.put("msg", "注册失败");
			map.put("code", "0001");
		}
		return map;
	}
}
