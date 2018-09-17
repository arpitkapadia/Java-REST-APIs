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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.aw.services.repository.*;
import com.aw.services.model.*;


@Controller    
@CrossOrigin
@RequestMapping(path="/login") 
public class LoginController {
	@Autowired 
	           
	private LoginActivityRepository loginActivityRepository;
	
	@Autowired 
	private UserRepository userRepository;
	

	@GetMapping(path="/authenticate") 
	public @ResponseBody ResponseUser authenticateUser(@RequestParam String userId, @RequestParam String password) {

		System.out.println("calling : " + userId + " " + password  +" " +  userRepository.findByUserId(userId));
				
		
		User user = userRepository.findByUserIdPassword(userId, password);
		
		if(user != null) {
			
			Integer id = user.getId();
			UserActivity ua = new UserActivity();
			ua.setUser(user);
			ua.setStatus(true);
			
			Date date = new Date();
			System.out.println(" here is the valid id and password " + id);

			
			ua.setTimestamp(new Timestamp(date.getTime()));
			loginActivityRepository.save(ua);
			
			return new ResponseUser(user, true, "login success");


		} else {
			User u = userRepository.findUser(userId);
			if(u != null) {
				UserActivity ua = new UserActivity();
				ua.setUser(u);
				
				System.out.println(" here is the id");
				ua.setStatus(new Boolean(false));
				
				Date date = new Date();
				
				ua.setTimestamp(new Timestamp(date.getTime()));
				loginActivityRepository.save(ua);			
				
				return new ResponseUser(user, false, "login failed - invalid userid or password");

			}


		}
		
		return new ResponseUser(user, true, "login success");

		

	}
	
	

}
