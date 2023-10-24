package com.exam.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Alias("MyPgDTO")
public class MyPgDTO {
	
	String userid;
	String email;
	String nickname;
	String phone;
	String pofolLink;
	String skills;
	String tools;
	String intro;
	
	public MyPgDTO() {}

	public MyPgDTO(String userid, String email, String nickname, String phone, String pofolLink, String skills,
			String tools, String intro) {
		this.userid = userid;
		this.email = email;
		this.nickname = nickname;
		this.phone = phone;
		this.pofolLink = pofolLink;
		this.skills = skills;
		this.tools = tools;
		this.intro = intro;
	}
	
	
}
