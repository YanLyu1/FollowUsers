/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw5.controller;

import com.hw5.dao.QuestionDirectory;
import com.hw5.pojo.Question;
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
    public QuizController() {
        answerMap= new HashMap<>();
        questionDir = new QuestionDirectory();
        questionnum = 1;
    }
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        ModelAndView mv = null;
        HttpSession session = request.getSession();
        Question question = null;
        
        //get answer user selected
        //int questionnum = Integer.parseInt(request.getParameter("questionnum"));
        String answer = request.getParameter("answer");
        
        //get question to display on page
        for(Question quest : questionDir.getQuestionlist()){
            if(quest.getNumber() == questionnum){
                question = quest;
            }
        }
        
        //storage answer
        if(answer != null){
            answerMap.put(questionnum-1, answer);
        }
        
        questionnum = questionnum + 1;
        //request.setAttribute("questionnum", questionnum);
        if(questionnum > 11){
            session.setAttribute("answerMap", answerMap);
        }
        mv = new ModelAndView("quiz", "question", question);
        return mv;
    }
    
}
