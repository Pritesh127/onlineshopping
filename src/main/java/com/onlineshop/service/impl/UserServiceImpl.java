package com.onlineshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.entity.User;
import com.onlineshop.repository.UserRepository;
import com.onlineshop.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
		
	}

	@Override
	public User saveUser(User user) {
		userRepository.save(user);
		return null;
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
		
	}

}
