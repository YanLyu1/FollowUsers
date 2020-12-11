package com.me.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.servlet.ModelAndView;

import com.me.dao.PassageDao;
import com.me.dao.UserDao;
import com.me.exception.CommentException;
import com.me.exception.PassageException;
import com.me.exception.UserException;
import com.me.pojo.Comment;
import com.me.pojo.Passage;
import com.me.pojo.User;
import com.me.validator.PassageValidator;
import com.me.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class PassageController {
	@Autowired
	PassageValidator passagevalidator;
	
	@Autowired
	PassageDao passageDao;

	// Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(passagevalidator);
	}

	@RequestMapping(value="createPassage.htm", method = RequestMethod.GET)
	public String formView(ModelMap model,  HttpServletRequest req) {
		
		Passage passage = new Passage();
		model.addAttribute("passage", passage);
		return "createPassage";
	}
	
	@RequestMapping(value="deletePassage.htm", method = RequestMethod.GET)
	public ModelAndView deleteformView(ModelMap model,  HttpServletRequest req) throws PassageException {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null) {
			return new ModelAndView("login");
		}else {
			long id =Long.parseLong(req.getParameter("passageId"));
			System.out.println(user);
			ArrayList<Passage> passages = (ArrayList<Passage>) passageDao.deletePassage(id,user);
			return new ModelAndView("viewOwnPassage","passageList",passages);
		}
	}
	
	
	@RequestMapping(value="viewAllPassage.htm", method = RequestMethod.GET)
	public ModelAndView viewAllPassageView(ModelMap model, Passage passage,  HttpServletRequest req) throws PassageException {
		ArrayList<Passage> passages = (ArrayList<Passage>) passageDao.getPassages();
		req.setAttribute("passageList", passages);
		return new ModelAndView("viewAllPassage","passageList",passages);
	}
	
	//在这里加👍
		@RequestMapping(value="viewAllPassage.htm", method = RequestMethod.POST)
		public ModelAndView viewAllPassageLikeView(ModelMap model, Passage passage,  HttpServletRequest req) throws PassageException, UserException {
			HttpSession s = req.getSession();
			if(s.getAttribute("user")!=null) {
				User user=(User)s.getAttribute("user");
				long passageId = Long.parseLong(req.getParameter("passageId"));
				passage = passageDao.get(passageId);
				int i = passageDao.likeArticle(passage, user);
				ArrayList<Passage> passages = (ArrayList<Passage>) passageDao.getPassages();
				req.setAttribute("passageList", passages);
				return new ModelAndView("viewAllPassage","passageList",passages);
				}
			return new ModelAndView("login");
		}
	
	@RequestMapping(value="viewOwnPassage.htm", method = RequestMethod.GET)
	public ModelAndView viewOwnPassageView(ModelMap model, Passage passage, HttpServletRequest req) throws PassageException {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null) {
			return new ModelAndView("login");
		}else {
		ArrayList<Passage> passages = (ArrayList<Passage>) passageDao.getOwnPassages(user);
		req.setAttribute("passageList", passages);
		return new ModelAndView("viewOwnPassage","passageList",passages);
		}
	}
	
	
	@RequestMapping(value="editOwnPassage.htm", method = RequestMethod.POST)
	public String updateFormView(ModelMap model, Passage passage, HttpServletRequest req) throws PassageException {
		HttpSession s = req.getSession();
		if(s.getAttribute("user")!=null) {
			User user=(User)s.getAttribute("user");
			passage.setUser(user);
			long passageId = Long.parseLong(req.getParameter("passageId"));
			passage = passageDao.get(passageId);
			model.addAttribute("passage", passage);
			s.setAttribute("passage", passage);
			
			return "editOwnPassage";
		}
		return "login";
	}
	
	@RequestMapping(value="viewOnePublicPassage.htm", method = RequestMethod.GET)
	public ModelAndView viewPublicPassageCommentFormView(ModelMap model, Passage passage, HttpServletRequest req) throws PassageException, CommentException {
		HttpSession s = req.getSession();
		if(s.getAttribute("user")!=null) {
			String commentContent = req.getParameter("commentContent");
			if(commentContent!=null) {
				User user=(User)s.getAttribute("user");
				long passageId = Long.parseLong(req.getParameter("passageId"));
				passage = passageDao.get(passageId);
				Set<Comment> commentList = passageDao.addComment(passage, commentContent, user);
				s.setAttribute("passage", passage);
				return new ModelAndView("viewOnePublicPassage","commentList",commentList);
			}
			return new ModelAndView("viewAllPassage");
		}
		return new ModelAndView("login");
	}
	
	
	
	
	@RequestMapping(value="viewOnePublicPassage.htm", method = RequestMethod.POST)
	public String viewPublicPassageFormView(ModelMap model, Passage passage, HttpServletRequest req) throws PassageException {
		HttpSession s = req.getSession();
		if(s.getAttribute("user")!=null) {
			User user=(User)s.getAttribute("user");
			passage.setUser(user);
			long passageId = Long.parseLong(req.getParameter("passageId"));
			passage = passageDao.get(passageId);
			model.addAttribute("passage", passage);
			s.setAttribute("passage", passage);
			
			return "viewOnePublicPassage";
		}
		return "login";
	}
	
//	@ModelAttribute("passage") Passage passage,
	
	@RequestMapping(value="create-passage-success.htm", method = RequestMethod.POST)
	public ModelAndView successCreateView(@Validated @ModelAttribute("passage") Passage passage,  BindingResult bindingResult, ModelMap model,HttpServletRequest req) throws UserException, PassageException {
		//如果用户名或密码不符合 返回 create Passage
		if (bindingResult.hasErrors()) {		
			return new ModelAndView("createPassage");  //the are validation errors, go to the form view
		}
		HttpSession s = req.getSession();
		if(s.getAttribute("user")!=null) {
			User user=(User)s.getAttribute("user");
			passage.setUser(user);
			Passage pass = passageDao.createPassage(passage);
			ArrayList<Passage> passages = (ArrayList<Passage>) passageDao.getOwnPassages(user);
			req.setAttribute("passageList", passages);
			return new ModelAndView("viewOwnPassage","passageList", passages);
		}
		
//		session user 不存在 去登陆
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="viewOwnPassage.htm", method = RequestMethod.POST)
	public ModelAndView successUpdateView(@Validated @ModelAttribute("passage") Passage passage, BindingResult bindingResult, ModelMap model,HttpServletRequest req) throws UserException, PassageException {
		//如果用户名或密码不符合 返回自己
		if (bindingResult.hasErrors()) {		
			return new ModelAndView("editOwnPassage");  //the are validation errors, go to the form view
		}
		long passageId = Long.parseLong(req.getParameter("pId"));
		Passage p = passageDao.get(passageId);
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		String content = passage.getContent();
		p.setContent(content);
//		(Passage)session.getAttribute("passage"))
		if(user == null) {
			return new ModelAndView("login");
		}else {
			if(passageDao.updatePassage(p)) {
				ArrayList<Passage> passages = (ArrayList<Passage>) passageDao.getOwnPassages(user);
				req.setAttribute("passageList", passages);
				System.out.print(passage.getContent());
				
				return new ModelAndView("viewOwnPassage","passageList", passages);
			}else {
				return new ModelAndView("login");
			}
			
		}
		
	}

}
