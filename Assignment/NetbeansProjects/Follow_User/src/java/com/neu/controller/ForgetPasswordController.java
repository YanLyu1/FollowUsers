/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.captcha.botdetect.web.servlet.Captcha;
import com.neu.dao.UserDao;
import com.neu.email.SendMail;
import com.neu.pojo.User;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author root
 */
public class ForgetPasswordController extends AbstractController {
    
    public ForgetPasswordController() {
    }
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
        //reset
        String step = request.getParameter("step");
        if(step == null){
            
            return new ModelAndView("resetPassword");
        }else{
//            User admin = null;
            User user = null;
            String email = request.getParameter("email");
            String userName = request.getParameter("userName");
            PrintWriter out = response.getWriter();
            UserDao userDao = new UserDao();
            Captcha captcha = Captcha.load(request, "CaptchaObject");
            String captchaCode = request.getParameter("captchaCode");
            if(captcha.validate(captchaCode)){
                //实例化一个发送邮件的对象
//                return new ModelAndView("success");
		SendMail mySendMail = new SendMail();
                user = userDao.getUserByEmail(email);
                if(user!=null) {
                    if(user.getUserName().equals(userName)){
                        mySendMail.sendMail(email, "Blog password: "+user.getPassword());
//				out.println("<script>alert('Congratulations, found the password successfully.');window.location.href='login.htm'</script>");
                    }else{
                        return new ModelAndView("resetPassword","error","UserName and Email NOT Match!!!");
                    }
                }
//		}
//		out.println("<script>alert('This email has not been registered! please enter again');window.location.href='registerUserAccount.htm'</script>");
                return new ModelAndView("login","error","password has sent to you ,you can login now");
            }else{
                return new ModelAndView("resetPassword","error","captcha wrong");
            }
        }
    }
    
}
