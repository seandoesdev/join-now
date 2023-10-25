package com.exam.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.exam.dto.ProjDTO;
import com.exam.dto.ProjDTO;
import com.exam.dto.QuestionDTO;
import com.exam.dto.ScheduleDTO;
import com.exam.dto.TestDTO;



@Repository
public class ProjTeamDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	/**
	 * 일정표
	 */
    // 일정 추가
	public int insertEvent(List<ScheduleDTO> scheduleDTO){
		return session.insert("ProjTeamMapper.insertEvent", scheduleDTO);
	}
	
	public List<ScheduleDTO> selectAllEventbyId(){
	  return session.selectList("ProjTeamMapper.selectAllEventbyId");
	}
	
	
	
	// 프로젝트 팀 페이지 - 프로젝트 팀 정보 얻기 
	public ProjDTO selectAllbyId() {
	  return session.selectOne("ProjTeamMapper.selectAllbyId");
	}
	
	// 질문 생성
	public int createPost (QuestionDTO questionDTO) {
	  return session.insert("ProjTeamMapper.createPost", questionDTO);
	}
}
