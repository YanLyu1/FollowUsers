package com.me.view.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

public class myPdfViewImpl extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Element e1 = new Chunk("this is a chunk, which is the smalles text could be added to a document");
		Element e2 = new Phrase("this is a series of chunk");
		Element e3 = new Paragraph("this is a paragraph. A paragraph is a seiries of Chunks and/or phrase:\r\n"+
		"\r\n"+
				"A paragraph has the same quantity of a phrase but alse some additional layout-parameters:");
		
		document.add(e1);
		document.add(e2);
		document.add(e3);
	}

}
