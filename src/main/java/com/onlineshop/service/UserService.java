package com.onlineshop.service;

import java.util.List;

import com.onlineshop.entity.User;

public interface UserService {

	List<User> getAllUsers();

	User saveUser(User user) ;
	void deleteUser(int id);
}
