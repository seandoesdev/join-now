package com.exam.dto;

import org.apache.ibatis.type.Alias;

@Alias("ApplyDTO")
public class ApplyDTO {
	
	String userid;
	String applyType;
	String skills;
	String contact;
	String content;
	int applyNo;
	int postNo;
	public ApplyDTO() {}
	
	public ApplyDTO(String userid, String applyType, String skills, String contact, String content, int applyNo,
			int postNo) {
		this.userid = userid;
		this.applyType = applyType;
		this.skills = skills;
		this.contact = contact;
		this.content = content;
		this.applyNo = applyNo;
		this.postNo = postNo;
	}



	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getApplyType() {
		return applyType;
	}
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getApplyNo() {
		return applyNo;
	}
	public void setApplyNo(int applyNo) {
		this.applyNo = applyNo;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	@Override
	public String toString() {
		return "ApplyDTO [userid=" + userid + ", applyType=" + applyType + ", skills=" + skills + ", contact=" + contact
				+ ", content=" + content + ", applyNo=" + applyNo + ", postNo=" + postNo + "]";
	}
	
	
}
