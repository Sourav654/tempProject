package com.example.demo.service.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.model.MyResponse;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Service
public interface DemoServiceDAO {
	
	Logger logger = LoggerFactory.getLogger(DemoServiceDAO.class);
	 static void inDAOmethod() {
		System.out.println("in DAO Service....");
	 }

	public MyResponse getValue(String myInput) throws Exception;

	
}
