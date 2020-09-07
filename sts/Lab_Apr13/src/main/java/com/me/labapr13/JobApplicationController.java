package com.me.labapr13;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.me.dao.ApplicationDAO;
import com.me.pojo.Applicant;

@Controller
public class JobApplicationController {
	@Autowired
	private ServletContext application;   //only static global instances to be AutoWired
	
	@PostConstruct
	public void init() {
		// initialize global instances
	}

	@PreDestroy
	public void destroy() throws Exception {
		// do cleanup
	}

	@RequestMapping(value = "/job/apply.htm", method = RequestMethod.GET)
	public String showForm(HttpServletRequest request, ModelMap model, Applicant applicant) {
		//command object
		//model.addAttribute("applicant", applicant);
		request.setAttribute("action", "save");
		return "job-form";
	}
	
	@RequestMapping(value = "/job/apply.htm", method = RequestMethod.POST)
	public String handleUpload(@ModelAttribute("applicant") Applicant applicant, ApplicationDAO applicaitonDAO) throws IllegalStateException, IOException {
//		System.out.println("upload successfully");
		String localPath = "‎Macintosh HD/Users/lvyan/Desktop/file";
		String photoName = generateFileName(applicant.getPhoto());
		String resumeName = generateFileName(applicant.getResume());
		applicant.getPhoto().transferTo(new File(localPath, photoName));
		try {
			File file = new File(localPath + resumeName);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(applicant.getResume().getBytes());
			fos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
//		System.out.println(applicant.getEmail());
		
		applicant.setPhotoPath(localPath +"/" +photoName);
		applicant.setResumePath(localPath +"/"+ resumeName);
		applicaitonDAO.create(applicant);
		return "job-success";
	}
	
	private String generateFileName(MultipartFile multiPartFile) {
		return new Date().getTime()+"-"+multiPartFile.getOriginalFilename().replace(" ", "_");
	}
	
	private void sendEmail(Applicant applicant) throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("ladadidadi123456@gmail.com","ly950223"));
		email.setSSLOnConnect(true);
		email.setFrom("ladadidadi123456@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ...");
		email.addTo(applicant.getEmail());
		email.send();
	}
}
