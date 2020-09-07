package com.me.report;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import com.me.view.impl.myPdfViewImpl;

@Controller
public class ReportController {
	@RequestMapping(value="/report.pdf", method=RequestMethod.GET)
	public View getReport() {
		View view = new myPdfViewImpl();
		return view;
	}
}
