package com.me.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.dao.UserDao;
import com.me.exception.UserException;
import com.me.pojo.User;
import com.me.validator.UserValidator;

@Controller
@RequestMapping("/register.htm")
public class UserRegisterController {
	@Autowired
	UserValidator uservalidator;
	
	@Autowired
	UserDao userDao;

	// Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(uservalidator);
	}

	@RequestMapping( method = RequestMethod.GET)
//	@RequestMapping("/register.htm")
	public String formView(ModelMap model, User user, HttpServletRequest req) {
		
		
		model.addAttribute("user", user);
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, ModelMap model,HttpServletRequest req ,HttpServletResponse resp) throws UserException, IOException {
		if (bindingResult.hasErrors()) {
			return "register";  //the are validation errors, go to the form view
		}
		if(userDao.isUserExsist(req.getParameter("name"))) {
			req.setAttribute("alert", "Dupulicate!!");
			return "register"; 
		}
		//no errors, so go to the success view
		
		req.setAttribute("alert", "");
		userDao.register(user);
		return "user-success";
	}

}
