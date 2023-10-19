package com.exam.service;

import java.util.List;
import com.exam.dto.ProjDTO;
import com.exam.dto.QuestionDTO;
import com.exam.dto.ScheduleDTO;
import com.exam.dto.TestDTO;


public interface ProjTeamService {
	public List<ScheduleDTO> insertSch();
	public List<TestDTO> testSelect();
	
	
	public ProjDTO selectAllbyId();
	
	// projTeam question에서 게시글 생성 
	public int createPost (QuestionDTO questionDTO);
}
