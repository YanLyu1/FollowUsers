/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw5.controller;

import com.hw5.dao.QuestionDirectory;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author root
 */
public class QuizController extends AbstractController {
    static public HashMap<Integer,String> answerMap;
    static int questionnum;
    private QuestionDirectory questionDir;
    private String answer;
    public QuizController() {
        answerMap= new  HashMap<>();
        questionDir = new QuestionDirectory();
        questionnum = 0;
    }
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        ModelAndView mv = null;
        HttpSession session = request.getSession();
      
        //get answer user selected
        answer = request.getParameter("answer");
        if(answer != null){
            answerMap.put(questionnum, answer);
        }     
        
        //get the next question
        questionnum = questionnum + 1;
        request.setAttribute("questionnum", questionnum);
        
        //after all question conpleted, return the amswer map
        if(questionnum >= 11){
            session.setAttribute("answerMap", answerMap);
        }
        mv = new ModelAndView("quiz", "questionDir", questionDir);
        
        return mv;
    }
    
}
