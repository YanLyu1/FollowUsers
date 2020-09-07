package com.neu.edu.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.UserDao;
import com.neu.edu.exception.UserException;
import com.neu.edu.pojo.Phone;
import com.neu.edu.pojo.User;

@Controller
@RequestMapping("/*")
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	protected ModelAndView home() throws Exception{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	protected String createUser() {
		Phone ph1 = new Phone();
		Phone ph2 = new Phone();
		ph1.setPhoneNumber("1231212");
		ph2.setPhoneNumber("43434344");
		
		Set<Phone> phoneNos = new HashSet<Phone>();
		
		User user = new User();
		user.setFname("Jon");
		user.setLname("Snow");
		phoneNos.add(ph1);
		phoneNos.add(ph2);
		user.setPhoneNumbers(phoneNos);
		
		User user2 = new User();
		user2.setFname("Ned");
		user2.setLname("Stark");
		user2.setPhoneNumbers(phoneNos);
		
		
		try {
			userDao.register(user);
			userDao.register(user2);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "home";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	protected String deleteEntry() {
		try {
			User user = userDao.get(1);
			userDao.delete(user);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "home";
	}
	
}
