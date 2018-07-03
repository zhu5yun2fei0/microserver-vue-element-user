package com.pktech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pktech.bean.User;
import com.pktech.dao.UserDao;
import com.pktech.service.UserService;

@Service
@Transactional(readOnly = false)
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userdao;

	@Override
	public User findByUsername(String phone) {
		return userdao.findByUsername(phone);
	}

	@Override
	public void saveUser(User user) {
		userdao.saveUser(user);
	}

}
