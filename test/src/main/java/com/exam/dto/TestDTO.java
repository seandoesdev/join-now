package com.exam.dto;

import org.apache.ibatis.type.Alias;

@Alias("TestDTO")
public class TestDTO {
	int id;
	int pw;
	public TestDTO() {
		
	}
	public TestDTO(int id, int pw) {
		this.id = id;
		this.pw = pw;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	
}
