package com.exam.service;

import java.util.List;
import com.exam.dto.MeetingDTO;
import com.exam.dto.MeetingPageDTO;
import com.exam.dto.ScheduleDTO;
import com.exam.dto.TestDTO;


public interface ProjTeamService {
  
    // 일정표 
	public int insertEvent(List<ScheduleDTO> scheduleDTO);
	public List<ScheduleDTO> selectAllEventbyId();
	public int updateEvent(ScheduleDTO scheduleDTO);
	public int deleteEvent(ScheduleDTO scheduleDTO);
	
	// 회의록
	public MeetingPageDTO getAllPost(int curPage);
	
	
	// 팀 정보

}
