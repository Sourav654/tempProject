package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.DemoController;
import com.example.demo.model.MyResponse;
import com.example.demo.service.dao.DemoServiceDAO;



@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DemoApplicationTests {
	
	  @InjectMocks
	  DemoController demoController;
	  
	  @Mock
	  DemoServiceDAO demoservice;
	  
	  
	  @Test
	  void contextLoads() { 
	  MyResponse res =null;
	  String s="123456789";
	  assertNotNull(demoController);
    //  when(demoController.).thenReturn(false);
	  res=demoController.newResp(s); 
	  System.out.println(res);
	  assertEquals(res.getCountThreeSixNine(), 3);
	  assertTrue(res.getIdName()>123456789);
	  assertEquals(res.getName(),"iCY"); }
	 

}
