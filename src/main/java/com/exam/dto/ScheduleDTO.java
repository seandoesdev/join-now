package com.exam.dto;

import org.apache.ibatis.type.Alias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Alias("ScheduleDTO")
public class ScheduleDTO {
  private int calendarId;
  private int teamId;
  private String title;
  private String start;
  private String end;
  private String color;

  public ScheduleDTO() {}

  public ScheduleDTO(int calendarId, int teamId, String title, String start, String end,
      String color) {
    this.calendarId = calendarId;
    this.teamId = teamId;
    this.title = title;
    this.start = start;
    this.end = end;
    this.color = color;
  }

  public int getCalendarId() {
    return calendarId;
  }

  public void setCalendarId(int calendarId) {
    this.calendarId = calendarId;
  }

  public int getTeamId() {
    return teamId;
  }

  public void setTeamId(int teamId) {
    this.teamId = teamId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getStart() {
    return start;
  }

  public void setStart(String start) {
    this.start = start;
  }

  public String getEnd() {
    return end;
  }

  public void setEnd(String end) {
    this.end = end;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }



 

}
