/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw5.controller;

import com.hw5.dao.QuestionDirectory;
import com.hw5.pojo.Answer;
import com.hw5.pojo.Question;
import com.hw5.validator.AnswerValidator;
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
        final private QuestionDirectory questionDir;
        private String action;
        
        public QuizController(){
            questionDir = new QuestionDirectory();
            setCommandClass(Answer.class);
            setCommandName("answers");
            setValidator(new AnswerValidator());
            action = "Next";
            setAllowDirtyForward(false);
            setAllowDirtyBack(false);
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
      
    /**
     *
     * @param request
     * @param page
     * @return
     * @throws Exception
     */
    @Override
    protected Map referenceData(HttpServletRequest request, int page) throws Exception { 
        Map map = new HashMap(); 
        if(page==0) {
            map.put("question", questionDir.getQuestion1()); 
        } 
        if(page==1) {
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
        
    /**
     *
     * @param request
     * @param command
     * @param errors
     * @param page
     * @throws Exception
     */
    @Override
    protected void postProcessPage(HttpServletRequest request,Object command,Errors errors,int page)throws Exception { 
        int targetPage = getTargetPage(request, page);
        request.setAttribute("page", targetPage);
//        Enumeration<String> names = request.getParameterNames();
//        request.setAttribute("action", names);
        //if next, -1. if previous, -0
//        if(errors.hasErrors())
//            request.setAttribute("page", targetPage-1);
    } 
    
    /**
     *
     * @param command
     * @param errors
     * @param page
     */
    @Override
    protected void validatePage(Object command, Errors errors, int page) { 
	AnswerValidator validator = (AnswerValidator)getValidator();
//	validator.validateAnswer(errors, page); 
        Answer an = (Answer)command;
        if(page==0) {
            String ans1 = an.getAnswer1();
            validator.validateAnswer(ans1, errors, "answer1");
        } 
        if(page==1) {
            String ans2 = an.getAnswer2();
            validator.validateAnswer(ans2, errors,"answer2");
        } 
        if(page==2){
            String ans3 = an.getAnswer3();
            validator.validateAnswer(ans3, errors,"answer3");
        }
        if(page==3){
            String ans4 = an.getAnswer4();
            validator.validateAnswer(ans4, errors,"answer4");
        }
        if(page==4){
            String ans5 = an.getAnswer5();
            validator.validateAnswer(ans5, errors,"answer5");
        }
        if(page==5){
            String ans6 = an.getAnswer6();
            validator.validateAnswer(ans6, errors,"answer6");
        }
        if(page==6){
            String ans7 = an.getAnswer7();
            validator.validateAnswer(ans7, errors,"answer7");
        }
        if(page==7){
            String ans8 = an.getAnswer8();
            validator.validateAnswer(ans8, errors,"answer8");
        }
        if(page==8){
            String ans9 = an.getAnswer9();
            validator.validateAnswer(ans9, errors,"answer9");
        }
        if(page==9){
            String ans10 = an.getAnswer10();
            validator.validateAnswer(ans10, errors,"answer10");
        }
    }
        
    /**
     *
     * @param request
     * @param res
     * @param command
     * @param errs
     * @return
     * @throws Exception
     */
//    @Override
	protected ModelAndView processFinish(HttpServletRequest request,HttpServletResponse res,Object command,BindException errs )throws Exception{
                HttpSession session = request.getSession();
                Answer answer = (Answer)command;
                Map<Integer, String> answermap = new HashMap <Integer, String>();
                answermap.put(1, answer.getAnswer1());
                answermap.put(2, answer.getAnswer2());
                answermap.put(3, answer.getAnswer3());
                answermap.put(4, answer.getAnswer4());
                answermap.put(5, answer.getAnswer5());
                answermap.put(6, answer.getAnswer6());
                answermap.put(7, answer.getAnswer7());
                answermap.put(8, answer.getAnswer8());
                answermap.put(9, answer.getAnswer9());
                answermap.put(10, answer.getAnswer10());
                session.setAttribute("answerMap", answermap);
                return new ModelAndView(getSuccessView(),"page",10);
	}
	
    /**
     *
     * @param req
     * @param request
     * @param command
     * @param errs
     * @return
     * @throws Exception
     */
    @Override
	protected ModelAndView processCancel(HttpServletRequest req,HttpServletResponse request,Object command,BindException errs)throws Exception{
            Question question = questionDir.getQuestion1();
            req.setAttribute("page", 0);
            return new ModelAndView("redirect:quiz.htm","question",question);
	}
   }