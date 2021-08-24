package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.DemoApplication;
import com.example.demo.model.MyResponse;
import com.example.demo.service.dao.DemoServiceDAO;

@Service
public class DemoServiceImpl implements DemoServiceDAO {
	Logger logger =LoggerFactory.getLogger(DemoServiceImpl.class);
	public DemoServiceImpl() {
		super();
		System.out.println("Inside DemoServiceImpl... ");
	}
	@Override
	public MyResponse getValue(String myInput) throws Exception{
		// TODO Auto-generated method stub
		MyResponse res = new MyResponse();
		logger.debug("Started getValue in DemoServiceImpl" );
		if(myInput!=null) {
			List<String> array = Arrays.asList(myInput.split(""));
			res.setCountThreeSixNine(Long.valueOf( array.stream().filter(a->{ return isThreeSixNine(a);}).count()).intValue());
			res.setName(getNewName(array));
			Random rand = new Random();
			int ran =Math.abs(rand.nextInt());
			List<String> filteredNumber =array.stream().filter(a->{return NumberUtils.isCreatable(a);}).collect(Collectors.toList());
			String newString  =filteredNumber.stream().reduce("",(a,b)->a+ String.valueOf(b));
			res.setIdName(Long.parseLong(String.valueOf(ran)+newString ));
			logger.info("Response: "+res);
		}
		logger.debug("Completed getValue in DemoServiceImpl" );
		return res;
	}
	public Boolean isThreeSixNine(String num) {
		logger.debug("Started isThreeSixNine in DemoServiceImpl" );
		Boolean isValid =false;
		if(num!=null && NumberUtils.isCreatable(num)) {
			if(num.equals("3") || num.equals("6")|| num.equals("9")) {
				isValid=true;
			}
		}
		return isValid;
	}
	public String getNewName(List<String> input) {
		logger.debug("Started getNewName in DemoServiceImpl" );
		StringBuilder s= new StringBuilder();
		String name="";
		for(int i=0;i<input.size(); i++) {
			if(NumberUtils.isCreatable(input.get(i))) {
				name =name.trim() +input.get(i).trim();
				if(NumberUtils.isCreatable(name)) {
					Integer numnew =Integer.parseInt(name);
					if(Character.isAlphabetic(numnew)) {
						logger.info("Using Alphabetic");
						s.append(String.valueOf((char)numnew.intValue()));
						name="";
						logger.info("reset name char");
					}else if((numnew>=65 && numnew<=90)||(numnew>=97 && numnew<=122)) {
						logger.info("Using ASCII value");
						s.append(String.valueOf((char)numnew.intValue()));
						name="";
						logger.info("reset name char");
					}else {
						logger.info("continue to new value.");
						List<String> l2 =Arrays.asList( name.split(""));
						Integer sum=l2.stream().mapToInt(Integer::parseInt).sum();
						if(sum>12 && sum<99) {
							sum =Integer.parseInt(sum.toString().substring(0,1))+Integer.parseInt(sum.toString().substring(1,2));
						}
						name= String.valueOf(sum);
					}	
				}
			}else {
				s.append(input.get(i));
			}
		}
		return s.toString();
	}

}

