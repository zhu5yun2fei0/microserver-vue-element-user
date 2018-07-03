package com.pktech.dao;

import org.apache.ibatis.annotations.Mapper;

import com.pktech.bean.User;
@Mapper
public interface UserDao {
	public User findByUsername(String phone);
	public void saveUser(User user);
}
