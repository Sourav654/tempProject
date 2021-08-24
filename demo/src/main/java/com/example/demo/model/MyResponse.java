package com.example.demo.model;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import org.springframework.stereotype.Component;

@Component
public class MyResponse implements Serializable{
 
	private static final Long serialVersionUID = 42L;
	private Integer countThreeSixNine;
	private String name;
	private Long idName;
	
	public MyResponse() {
		super();
	}

	public MyResponse(Integer countThreeSixNine, String name, Long idName) {
		super();
		this.countThreeSixNine = countThreeSixNine;
		this.name = name;
		this.idName = idName;
	}

	
	public Integer getCountThreeSixNine() {
		return countThreeSixNine;
	}

	public void setCountThreeSixNine(Integer countThreeSixNine) {
		this.countThreeSixNine = countThreeSixNine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getIdName() {
		return idName;
	}

	public void setIdName(Long idName) {
		this.idName = idName;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
	
 
}
