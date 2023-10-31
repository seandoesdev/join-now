package com.exam.service;

import java.util.HashMap;
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
	public MeetingPageDTO getAllPost(HashMap<String, Integer> hashmap); // 회의록 목록 조회 + 페이징 처리
	public int addMeetingPost(MeetingDTO meetingDTO);  // 회의록 작성
	public MeetingDTO selectOneById(HashMap<String, Integer> map); // 상세페이지
	public int deleteOneById(HashMap<String, Integer> map); // 회의록 삭제
	public int updateMeetingById(HashMap<String, Object> map); // 희의록 수정
	
	// 팀 정보

}
