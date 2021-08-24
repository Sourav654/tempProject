package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MyResponse;
import com.example.demo.service.dao.DemoServiceDAO;
import com.example.demo.service.impl.DemoServiceImpl;



@RestController
@RequestMapping(value = "/demo", method =RequestMethod.POST)
public class DemoController {
	

	 Logger logger =LoggerFactory.getLogger(DemoController.class);
	
	@PostMapping(value ="/newResp", headers ="Accept=Application/JSON", produces="Application/JSON")
	public MyResponse newResp(@RequestBody String myInput) {
		MyResponse myResponse = null;
		try {
			DemoServiceDAO demoServiceDAO = new DemoServiceImpl();
			logger.debug("Started getValue() method...");
			myResponse=demoServiceDAO.getValue(myInput);
			logger.debug("Completed getValue() method...");
			
		}
		catch(Exception e){
			logger.debug("Exception occurs",e);
			e.printStackTrace();
			System.out.println("Exception occurs");
		}		
		return myResponse;
		
	}

}
