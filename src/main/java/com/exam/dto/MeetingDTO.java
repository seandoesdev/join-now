package com.exam.dto;

import org.apache.ibatis.type.Alias;

@Alias("MeetingDTO")
public class MeetingDTO {
  
  private int teamId;
  private String writer;
  private String title;
  private String content;
  private String createDate;
  private String modifiedDate;
  
  public MeetingDTO() {}

  public MeetingDTO(int teamId, String writer, String title, String content, String createDate,
      String modifiedDate) {
    this.teamId = teamId;
    this.writer = writer;
    this.title = title;
    this.content = content;
    this.createDate = createDate;
    this.modifiedDate = modifiedDate;
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

  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

  public String getModifiedDate() {
    return modifiedDate;
  }

  public void setModifiedDate(String modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  @Override
  public String toString() {
    return "MeetingDTO [teamId=" + teamId + ", writer=" + writer + ", title=" + title + ", content="
        + content + ", createDate=" + createDate + ", modifiedDate=" + modifiedDate + "]";
  }

  
  
}
