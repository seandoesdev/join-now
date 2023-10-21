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
	String recruitType;
	int memberSize1;
	int memberSize2;
	int memberSize3;
	String content;
	String userid;
	boolean closing;
	String post_date;
	int viewCount;
	String deadline;
	String startDate;
	String skills;
	String contact;
	String category1;
	String category2;
	
	public PostDTO() {}

	public PostDTO(int postNo, String title, String studyType, String onoff, String region, String recruitType,
			int memberSize1, int memberSize2, int memberSize3, String content, String userid, boolean closing,
			String post_date, int viewCount, String deadline, String startDate, String skills, String contact,
			String category1, String category2) {
		this.postNo = postNo;
		this.title = title;
		this.studyType = studyType;
		this.onoff = onoff;
		this.region = region;
		this.recruitType = recruitType;
		this.memberSize1 = memberSize1;
		this.memberSize2 = memberSize2;
		this.memberSize3 = memberSize3;
		this.content = content;
		this.userid = userid;
		this.closing = closing;
		this.post_date = post_date;
		this.viewCount = viewCount;
		this.deadline = deadline;
		this.startDate = startDate;
		this.skills = skills;
		this.contact = contact;
		this.category1 = category1;
		this.category2 = category2;
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

	public String getRecruitType() {
		return recruitType;
	}

	public void setRecruitType(String recruitType) {
		this.recruitType = recruitType;
	}

	public int getMemberSize1() {
		return memberSize1;
	}

	public void setMemberSize1(int memberSize1) {
		this.memberSize1 = memberSize1;
	}

	public int getMemberSize2() {
		return memberSize2;
	}

	public void setMemberSize2(int memberSize2) {
		this.memberSize2 = memberSize2;
	}

	public int getMemberSize3() {
		return memberSize3;
	}

	public void setMemberSize3(int memberSize3) {
		this.memberSize3 = memberSize3;
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

	public String getCategory1() {
		return category1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	@Override
	public String toString() {
		return "PostDTO [postNo=" + postNo + ", title=" + title + ", studyType=" + studyType + ", onoff=" + onoff
				+ ", region=" + region + ", recruitType=" + recruitType + ", memberSize1=" + memberSize1
				+ ", memberSize2=" + memberSize2 + ", memberSize3=" + memberSize3 + ", content=" + content + ", userid="
				+ userid + ", closing=" + closing + ", post_date=" + post_date + ", viewCount=" + viewCount
				+ ", deadline=" + deadline + ", startDate=" + startDate + ", skills=" + skills + ", contact=" + contact
				+ ", category1=" + category1 + ", category2=" + category2 + "]";
	}




	
}
