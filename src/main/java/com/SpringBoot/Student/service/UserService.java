package com.SpringBoot.Student.service;

import java.util.List;



import com.SpringBoot.Student.model.User;

public interface UserService {
	
	List<User> getAllUser();
	
	User saveUser(User user);
	
	User getUserById(String uid);
	
	void deleteUserById(String uid);

	/* @Query("SELECT u FROM UserEntity u WHERE u.uid=:id OR u.uname=:name") */
	
	  List<User> searchbyIdAndName(String uid,String uname);
	 
}
