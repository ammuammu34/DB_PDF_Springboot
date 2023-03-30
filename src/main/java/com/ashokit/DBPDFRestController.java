package com.ashokit;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class DBPDFRestController{
	@Autowired
	private StudentService service; 
	
	@GetMapping("/exportpdf")
	public void generatePDF(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		DateFormat df = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		String currentDateTime = df.format(new Date(0));
		String headerkey = "Content-Disposition";
	    String headervalue = "attachment; filename=student" + currentDateTime + ".pdf";

	    List<Student> studentCourse = service.listAll();
	    PDFGenerator generator = new PDFGenerator();
	    generator.generate(studentCourse, response);
	}

}
