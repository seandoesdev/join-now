package com.exam.dto;

import org.apache.ibatis.type.Alias;

@Alias("PostDTO")
public class PostDTO {
	int postNo;
	String studyType;
	String title;
	String onoff;
	String region;
	String recruitType;
	int memberSize;
	String content;
	String userid;
	String closing;
	String viewCount;
	String deadline;
	String startDate;
	String skills;
	String contact;
	
	public PostDTO() {}

	public PostDTO(int postNo, String studyType, String title, String onoff, String region, String recruitType,
			int memberSize, String content, String userid, String closing, String viewCount, String deadline,
			String startDate, String skills, String contact) {
		this.postNo = postNo;
		this.studyType = studyType;
		this.title = title;
		this.onoff = onoff;
		this.region = region;
		this.recruitType = recruitType;
		this.memberSize = memberSize;
		this.content = content;
		this.userid = userid;
		this.closing = closing;
		this.viewCount = viewCount;
		this.deadline = deadline;
		this.startDate = startDate;
		this.skills = skills;
		this.contact = contact;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getStudyType() {
		return studyType;
	}

	public void setStudyType(String studyType) {
		this.studyType = studyType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOnoff() {
		return onoff;
	}

	public void setOnoff(String onoff) {
		this.onoff = onoff;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRecruitType() {
		return recruitType;
	}

	public void setRecruitType(String recruitType) {
		this.recruitType = recruitType;
	}

	public int getMemberSize() {
		return memberSize;
	}

	public void setMemberSize(int memberSize) {
		this.memberSize = memberSize;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getClosing() {
		return closing;
	}

	public void setClosing(String closing) {
		this.closing = closing;
	}

	public String getViewCount() {
		return viewCount;
	}

	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
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
	
	
}
