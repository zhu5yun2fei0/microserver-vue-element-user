package com.pktech.service;

import com.pktech.bean.User;

public interface UserService {
	public User findByUsername(String phone);
	public void saveUser(User user);
}
