package com.exam.dto;

import org.apache.ibatis.type.Alias;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
@NoArgsConstructor
@Alias("ScheduleDTO")
public class ScheduleDTO {
	private int calendarId;
	private String title;
	private String startDate;
	private String endDate;
	private String color;
	

  public ScheduleDTO(int calendarId, String title, String startDate, String endDate, String color) {
    this.calendarId = calendarId;
    this.title = title;
    this.startDate = startDate;
    this.endDate = endDate;
    this.color = color;
  }


  public int getCalendarId() {
    return calendarId;
  }


  public void setCalendarId(int calendarId) {
    this.calendarId = calendarId;
  }


  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public String getStartDate() {
    return startDate;
  }


  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }


  public String getEndDate() {
    return endDate;
  }


  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }


  public String getColor() {
    return color;
  }


  public void setColor(String color) {
    this.color = color;
  }
  
	
	
	
}
