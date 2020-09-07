package com.neu.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.AdvertDao;
import com.neu.edu.dao.CategoryDao;
import com.neu.edu.dao.UserDao;
import com.neu.edu.exception.CategoryException;
import com.neu.edu.pojo.Advert;

@Controller
@RequestMapping("/advert/*")
public class AdvertController {
	@Autowired
	UserDao userDao;
	@Autowired
	AdvertDao advertDao;
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView createAdvert() {
		ModelAndView mv= new ModelAndView();
		
		try {
			mv.addObject("category", categoryDao.list());
			mv.addObject("advert", new Advert());
		} catch (CategoryException e) {
			e.printStackTrace();
		}
		
		return mv;
	}
		
	
	
}
