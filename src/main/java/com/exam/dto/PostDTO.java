package com.exam.dto;

import org.apache.ibatis.type.Alias;

@Alias("PostDTO")
public class PostDTO {
	
	// TODO:
	
	int postNo;
	String title;
	String studyType;
	String onoff;
	String region;
	String content;
	String userid;
	boolean closing;
	String post_date;
	int viewCount;
	String deadline;
	String startDate;
	String skills;
	String contact;
	
	public PostDTO() {}

	public PostDTO(int postNo, String title, String studyType, String onoff, String region, String content,
			String userid, boolean closing, String post_date, int viewCount, String deadline, String startDate,
			String skills, String contact) {
		this.postNo = postNo;
		this.title = title;
		this.studyType = studyType;
		this.onoff = onoff;
		this.region = region;
		this.content = content;
		this.userid = userid;
		this.closing = closing;
		this.post_date = post_date;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStudyType() {
		return studyType;
	}

	public void setStudyType(String studyType) {
		this.studyType = studyType;
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

	public boolean isClosing() {
		return closing;
	}

	public void setClosing(boolean closing) {
		this.closing = closing;
	}

	public String getPost_date() {
		return post_date;
	}

	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
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

	@Override
	public String toString() {
		return "PostDTO [postNo=" + postNo + ", title=" + title + ", studyType=" + studyType + ", onoff=" + onoff
				+ ", region=" + region + ", content=" + content + ", userid=" + userid + ", closing=" + closing
				+ ", post_date=" + post_date + ", viewCount=" + viewCount + ", deadline=" + deadline + ", startDate="
				+ startDate + ", skills=" + skills + ", contact=" + contact + "]";
	}



	
}
