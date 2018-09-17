
package com.aw.services.controller;
import java.util.HashMap;
import java.util.Date;
import java.util.*;
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
public class LoginActivityController {
	
	@Autowired 
	           
	private LoginActivityRepository loginActivityRepository;
	

	@GetMapping(path="/LoginActivity") 
	public @ResponseBody List<UserActivity> authenticateUser(@RequestParam int id) {

		System.out.println("calling : " + id + " ");
		return loginActivityRepository.findAllUserActivity(id);

	}
	
	

}

