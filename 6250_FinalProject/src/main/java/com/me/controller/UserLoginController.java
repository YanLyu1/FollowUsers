package com.me.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.me.dao.PassageDao;
import com.me.dao.UserDao;
import com.me.exception.PassageException;
import com.me.exception.UserException;
import com.me.pojo.Passage;
import com.me.pojo.User;
import com.me.validator.UserValidator;

@Controller

public class UserLoginController {
	@Autowired
	UserValidator uservalidator;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	PassageDao passageDao;

	// Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(uservalidator);
	}

	@RequestMapping(value="login.htm", method = RequestMethod.GET)
	public String formView(ModelMap model, User user, HttpServletRequest req) {
		model.addAttribute("user", user);
		return "login";
	}

	@RequestMapping(value="user.htm", method = RequestMethod.POST)
	public String successView(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, ModelMap model,HttpServletRequest req) throws UserException, PassageException {
		
		
		//如果用户名或密码不符合 返回“login”
		if (userDao.login(user.getName(), user.getPassword())==null ) {		//差个validation！！！！
			
			return "login";  //the are validation errors, go to the form view
		}
		user = userDao.login(user.getName(), user.getPassword());
		//no errors, so go to the success view
		HttpSession s = req.getSession();
		s.setAttribute("user", user);
		Passage passage = new Passage();
//		model.addAttribute("passage",passage);
		req.setAttribute("passage", passage);
		ArrayList<Passage> passages = (ArrayList<Passage>) passageDao.getPassages();
		req.setAttribute("passageList", passages);
		return "viewAllPassage";
	}

}
