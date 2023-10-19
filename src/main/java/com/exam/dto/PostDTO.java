package com.exam.dto;

import org.apache.ibatis.type.Alias;

@Alias("PostDTO")
public class PostDTO {
	
//	int no;
//	String application_status;
//	String recruitment_period;
//	String start_date;
//	String type;
//	String progress;
//	String contact;
//	String skills;
//	String title;
//	String region;
//	String context;
//	int readcnt;
//	String userid;
//	String deadline;
//	String write_date;
//	int memberSize;
	

	
	int postNo;
	String title;
	String studyType;
	String onoff;
	String region;
	String recruitType;
	String recruitType2;
	String recruitType3;
	int memberSize;
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
	
	public PostDTO() {}



	public PostDTO(int postNo, String title, String studyType, String onoff, String region, String recruitType,
			String recruitType2, String recruitType3, int memberSize, int memberSize2, int memberSize3, String content,
			String userid, boolean closing, String post_date, int viewCount, String deadline, String startDate,
			String skills, String contact) {
		this.postNo = postNo;
		this.title = title;
		this.studyType = studyType;
		this.onoff = onoff;
		this.region = region;
		this.recruitType = recruitType;
		this.recruitType2 = recruitType2;
		this.recruitType3 = recruitType3;
		this.memberSize = memberSize;
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
	}









	public String getRecruitType2() {
		return recruitType2;
	}



	public void setRecruitType2(String recruitType2) {
		this.recruitType2 = recruitType2;
	}



	public String getRecruitType3() {
		return recruitType3;
	}



	public void setRecruitType3(String recruitType3) {
		this.recruitType3 = recruitType3;
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



	public String getOnoff() {
		return onoff;
	}




	public void setOnoff(String onoff) {
		this.onoff = onoff;
	}




	public String getContact() {
		return contact;
	}




	public void setContact(String contact) {
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


	@Override
	public String toString() {
		return "PostDTO [postNo=" + postNo + ", title=" + title + ", studyType=" + studyType + ", onoff=" + onoff
				+ ", region=" + region + ", recruitType=" + recruitType + ", recruitType2=" + recruitType2
				+ ", recruitType3=" + recruitType3 + ", memberSize=" + memberSize + ", memberSize2=" + memberSize2
				+ ", memberSize3=" + memberSize3 + ", content=" + content + ", userid=" + userid + ", closing="
				+ closing + ", post_date=" + post_date + ", viewCount=" + viewCount + ", deadline=" + deadline
				+ ", startDate=" + startDate + ", skills=" + skills + ", contact=" + contact + "]";
	}


	
}
