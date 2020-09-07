/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import VIEW.ReportView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.tiles2.TilesView;

/**
 *
 * @author root
 */
public class ReportController extends AbstractController {
    
    public ReportController() {
    }
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //redirect means, don't go to view resolver, go to this view/controller
//        return new ModelAndView("redirect:view.htm");
        View view = new ReportView();
//        View view = new TilesView();
//        View view2 = new FreeMarkerView();
//        View view3 = new GroovyMarkupView();
        return new ModelAndView(view);
    }
    
}
