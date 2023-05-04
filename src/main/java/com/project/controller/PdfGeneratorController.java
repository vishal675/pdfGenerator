package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.project.model.Invoice;
import com.project.service.DataMapper;
import com.project.service.PdfGeneratorService;


@RestController
@RequestMapping("/pdf")
public class PdfGeneratorController {
    
	@Autowired
	private SpringTemplateEngine engine;
	
	@Autowired
	private DataMapper dataMapper;
	
	@Autowired
	private PdfGeneratorService service;
	
	@PostMapping(value="/generate")
	public String generateDocument(@RequestBody Invoice invoice) {
		Context dataContext=dataMapper.setData(invoice);
		String finalHtml=engine.process("template", dataContext);
		service.generatePdf(finalHtml);
		return "success";
	}
}
