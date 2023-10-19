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
	
	// db 연결 테스트
    public List<TestDTO> testSelect() {
      return session.selectList("TestMapper.testSelect");
    }	
	
    // 일정 추가
	public List<ScheduleDTO> insertSch(){
		return session.selectList("ProjTeamMapper.insertSch");
	}
	
	
	// 프로젝트 팀 페이지 - 프로젝트 팀 정보 얻기 
	public ProjDTO selectAllbyId() {
	  return session.selectOne("ProjTeamMapper.selectAllbyId");
	}
	
	
	public int createPost (QuestionDTO questionDTO) {
	  return session.insert("ProjTeamMapper.createPost", questionDTO);
	}
}
