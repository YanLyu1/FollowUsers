package com.web.springMVC.controller;
import com.web.springMVC.model.RegisterInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

 public class RegisterController extends AbstractWizardFormController{
	private String successView;
	private String cancelView;
	public String getSuccessView() {
		return successView;
	}
	public void setSuccessView(String successView) {
		this.successView = successView;
	}
	public String getCancelView() {
		return cancelView;
	}
	public void setCancelView(String cancelView) {
		this.cancelView = cancelView;
	}
	protected ModelAndView processFinish(HttpServletRequest req,HttpServletResponse res,Object command,BindException errs )throws Exception{
		RegisterInfo registerInfo=(RegisterInfo)command;
		return new ModelAndView(this.getSuccessView(),"registerInfo",registerInfo);
	}
	
	protected ModelAndView processCancel(HttpServletRequest req,HttpServletResponse res,Object command,BindException errs)throws Exception{
		return new ModelAndView(this.getCancelView());
	}
   }

