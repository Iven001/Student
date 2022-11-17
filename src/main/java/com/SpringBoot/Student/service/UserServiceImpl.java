package com.SpringBoot.Student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.SpringBoot.Student.dao.UserRepository;
import com.SpringBoot.Student.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository usersRepository;
	
	@Override
	public List<User> getAllUser() {
		List<User> list=(List<User>) usersRepository.findAll();
		return list;
	}

	@Override
	public User saveUser(User user) {
		return usersRepository.save(user);
	}

	@Override
	public User getUserById(String uid) {
		return usersRepository.findById(uid).get();
	}

	@Override
	public void deleteUserById(String uid) {
		 usersRepository.deleteById(uid);
		
	}
	
	@Override
	public List<User> searchbyIdAndName(String id,String name) {
		List<User> list= usersRepository.searchbyIdAndName(id, name);
		return list;
	}

}
