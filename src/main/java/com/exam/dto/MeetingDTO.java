package com.exam.dto;

import java.sql.Date;
import java.time.LocalDateTime;
import org.apache.ibatis.type.Alias;

@Alias("MeetingDTO")
public class MeetingDTO {

  private int meetingId;
  private int teamId;
  private String writer;
  private String title;
  private String content;
  private LocalDateTime createdDate;
  private Date modifiedDate;



  public MeetingDTO() {}



  public MeetingDTO(int meetingId, int teamId, String writer, String title, String content,
      LocalDateTime createdDate, Date modifiedDate) {
    this.meetingId = meetingId;
    this.teamId = teamId;
    this.writer = writer;
    this.title = title;
    this.content = content;
    this.createdDate = createdDate;
    this.modifiedDate = modifiedDate;
  }



  public int getMeetingId() {
    return meetingId;
  }



  public void setMeetingId(int meetingId) {
    this.meetingId = meetingId;
  }



  public int getTeamId() {
    return teamId;
  }



  public void setTeamId(int teamId) {
    this.teamId = teamId;
  }



  public String getWriter() {
    return writer;
  }



  public void setWriter(String writer) {
    this.writer = writer;
  }



  public String getTitle() {
    return title;
  }



  public void setTitle(String title) {
    this.title = title;
  }



  public String getContent() {
    return content;
  }



  public void setContent(String content) {
    this.content = content;
  }



  public LocalDateTime getCreatedDate() {
    return createdDate;
  }



  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }



  public Date getModifiedDate() {
    return modifiedDate;
  }



  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }



}
