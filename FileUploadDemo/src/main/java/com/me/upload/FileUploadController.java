package com.me.upload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.me.pojo.User;

@Controller
public class FileUploadController {
	@RequestMapping(value = "/upload.htm", method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		User user = new User(); // should be AutoWired

		// command object
		model.addAttribute("user", user);

		// return form view
		return "user-form";

	}

	@RequestMapping(value = "/upload.htm", method = RequestMethod.POST)
	public String handleUpload(@ModelAttribute("user") User user) {
		try {
			// Multipart file will be in the memory.
			// We need to transfer to a file
			List<CommonsMultipartFile> photos = user.getPhoto();

			for (CommonsMultipartFile photo : photos) {
				String fileName = photo.getOriginalFilename();
				// could generate file names as well

				File localFile = new File("/Users/lvyan/Desktop", fileName);

				// move the file from memory to the file
				photo.transferTo(localFile);
			}
		} catch (IllegalStateException e) {
			System.out.println("*** IllegalStateException: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("*** IOException: " + e.getMessage());
		}

		return "user-success";
	}

}
