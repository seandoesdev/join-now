package com.exam.dto;

import org.apache.ibatis.type.Alias;

@Alias("TestDTO")
public class TestDTO {
	int id;
	String pw;
	public TestDTO() {
		
	}
	public TestDTO(int id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
}
