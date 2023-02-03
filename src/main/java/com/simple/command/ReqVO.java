package com.simple.command;

import java.util.List;

public class ReqVO {

	private String name;
	private int age;
	private List<String>inter;
	
	
	
	public ReqVO() {
	}



	public ReqVO(String name, int age, List<String> inter) {
		super();
		this.name = name;
		this.age = age;
		this.inter = inter;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public List<String> getInter() {
		return inter;
	}



	public void setInter(List<String> inter) {
		this.inter = inter;
	}



	@Override
	public String toString() {
		return "ReqVO [name=" + name + ", age=" + age + ", inter=" + inter + "]";
	}
	
	
	
	
}
