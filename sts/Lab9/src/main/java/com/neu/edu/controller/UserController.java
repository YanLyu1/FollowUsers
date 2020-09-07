package com.neu.edu.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.UserDao;
import com.neu.edu.pojo.Phone;
import com.neu.edu.pojo.User;

@Controller
@RequestMapping("/user/*")
public class UserController {

	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	protected ModelAndView registerUser() throws Exception {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		Set<Phone> phoneNumbers = new HashSet<Phone>();
		phoneNumbers.add(new Phone("1234567890"));
		phoneNumbers.add(new Phone("0987654321"));
		user.setPhoneNumbers(phoneNumbers);
		user = userDao.register(user);
		return new ModelAndView("view-user", "user", user);
	}

}
