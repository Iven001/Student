package com.SpringBoot.Student.dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SpringBoot.Student.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	

	
	  @Query("SELECT u FROM User u WHERE u.uid=:uid OR u.uname=:uname")
	  List<User> searchbyIdAndName(String uid,String uname);
	 
}
