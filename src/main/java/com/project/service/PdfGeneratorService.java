package com.project.service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.pdf.PdfWriter;



@Service
public class PdfGeneratorService {
    public String generatePdf(String processHTML){
    	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    	try {
    	
    		PdfWriter pdfWriter= new PdfWriter(byteArrayOutputStream);
    		DefaultFontProvider defaultFont= new DefaultFontProvider(false,true,false);
    		
    		ConverterProperties convertProperties =new ConverterProperties();
    		convertProperties.setFontProvider(defaultFont);
    		
    		HtmlConverter.convertToPdf(processHTML,pdfWriter, convertProperties);
    		FileOutputStream fout=new FileOutputStream("C:/Users/BHARAT/Desktop/New Folder/Invoice.pdf");
    		byteArrayOutputStream.writeTo(fout);
    		byteArrayOutputStream.close();
    		
    		byteArrayOutputStream.flush();
    		fout.close();
    	}
    	catch(Exception e) {
    		
    	}
    	return null;
    }
}

