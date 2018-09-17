package com.aw.services.controller;
import java.util.HashMap;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.aw.services.repository.*;
import com.aw.services.model.*;


@Controller    
@CrossOrigin
public class SignUpController {
	@Autowired 
	           
	private LoginActivityRepository loginActivityRepository;
	
	@Autowired 
	private UserRepository userRepository;
	

	@GetMapping(path="/signup") 
	public @ResponseBody ResponseUser authenticateUser(@RequestParam String userId, @RequestParam String password, @RequestParam String firstName, @RequestParam String lastName) {

		System.out.println("calling : " + firstName + " " + lastName);
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUserId(userId);
		user.setPassword(password);
		
		User tmpUser = userRepository.findByUserIdPassword(userId, password);
		
		User currentUser = null;
		
		if(tmpUser == null) {
			
			userRepository.save(user);
			currentUser = userRepository.findByUserId(user.getUserId());
			UserActivity ua = new UserActivity();
			ua.setUser(currentUser);
			ua.setStatus(true);
			
			Date date = new Date();
			System.out.println(" here is the valid id and password ");

			
			ua.setTimestamp(new Timestamp(date.getTime()));
			loginActivityRepository.save(ua);
			return new ResponseUser(currentUser, true, "signup success");

		} 


		
		return new ResponseUser(null, false, "signup failed - user exist");

	}
	
	

}
