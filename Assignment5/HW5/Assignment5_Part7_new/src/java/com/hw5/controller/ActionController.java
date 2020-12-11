/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw5.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author root
 */
public class ActionController extends AbstractController {
    
    public ActionController() {
    }
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView mv = null;
        String option = request.getParameter("selection");
        if(option != null){
            if(option.equals("bm")){
                    mv = new ModelAndView("redirect:searchmovie.htm");
                }else{
                    mv = new ModelAndView("redirect:addmovie.htm");
                }
                return mv;
        }else{
            mv = new ModelAndView("redirect:action.htm");
        }
        return mv;
    }
    
}
