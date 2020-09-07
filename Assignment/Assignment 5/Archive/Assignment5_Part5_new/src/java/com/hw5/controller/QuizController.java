/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw5.controller;

import com.hw5.dao.QuestionDirectory;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

/**
 *
 * @author root
 */
 public class QuizController extends AbstractWizardFormController{
 
	private String successView;
	private String cancelView;
        QuestionDirectory questionDir;
        static public HashMap<Integer,String> answerMap;
        //command should be a list of answer
        
        public QuizController(){
            questionDir = new QuestionDirectory();
            answerMap = new HashMap<>();
        }

        
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
        
    protected Map referenceData(HttpServletRequest request, int page) throws Exception { 
        Map map = new HashMap(); 
        if(page==0) { //如果是填写学校信息页 需要学校类型信息 
            map.put("question", questionDir.getQuestion1()); 
        } 
        if(page==1) {//如果是填写工作信息页 需要工作城市信息 
            map.put("question", questionDir.getQuestion2()); 
        } 
        if(page==2){
            map.put("question", questionDir.getQuestion3()); 
        }
        if(page==3){
            map.put("question", questionDir.getQuestion4());
        }
        if(page==4){
            map.put("question", questionDir.getQuestion5());
        }
        if(page==5){
            map.put("question", questionDir.getQuestion6());
        }
        if(page==6){
            map.put("question", questionDir.getQuestion7());
        }
        if(page==7){
            map.put("question", questionDir.getQuestion8());
        }
        if(page==8){
            map.put("question", questionDir.getQuestion9());
        }
        if(page==9){
            map.put("question", questionDir.getQuestion10());
        }
        
        return map; 
    } 
        
    protected void postProcessPage(HttpServletRequest request,Object command,Errors errors,int page)throws Exception { 

        int targetPage = getTargetPage(request, page);
        int currentPage = getCurrentPage(request);
        request.setAttribute("page", targetPage);
//        request.setAttribute("page", currentPage);
        String ans = request.getParameter("answer");
//        answerMap.put(targetPage, ans);
        answerMap.put(currentPage+1, ans);
    } 
    
    protected void validatePage(Object command, Errors errors, int page) { 
        //提供每一页数据的验证处理方法 
        super.validatePage(command, errors, page);
    }
        
	protected ModelAndView processFinish(HttpServletRequest request,HttpServletResponse res,Object command,BindException errs )throws Exception{
                HttpSession session = request.getSession();
                String ans = request.getParameter("answer");
                int pages = getPageCount() - 1;
                answerMap.put(pages, ans);
                session.setAttribute("answerMap", answerMap);
                return new ModelAndView("quiz");
	}
	
	protected ModelAndView processCancel(HttpServletRequest req,HttpServletResponse res,Object command,BindException errs)throws Exception{
		return new ModelAndView(this.getCancelView());
	}
   }


