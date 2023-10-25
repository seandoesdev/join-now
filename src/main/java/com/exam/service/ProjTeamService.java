package com.exam.service;

import java.util.List;
import com.exam.dto.ProjDTO;
import com.exam.dto.QuestionDTO;
import com.exam.dto.ScheduleDTO;
import com.exam.dto.TestDTO;


public interface ProjTeamService {
  
    // 일정표 
	public int insertEvent(List<ScheduleDTO> scheduleDTO);
	public List<ScheduleDTO> selectAllEventbyId();
	public int updateEvent(ScheduleDTO scheduleDTO);
	public int deleteEvent(ScheduleDTO scheduleDTO);
	
	
	// 팀 정보
	public ProjDTO selectAllbyId();
}
