package com.project.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import com.project.model.Invoice;


@Service
public class DataMapper {

	public Context setData(Invoice invoice) {
		Context context=new Context();
		
		Map<String,Object> hmap=new HashMap<>();
		
		hmap.put("Invoice", invoice);
		hmap.put("InvoiceItem", invoice.getItems());
		context.setVariables(hmap);
		return context;
	}
}
