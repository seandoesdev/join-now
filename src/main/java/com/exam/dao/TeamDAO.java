package com.exam.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.dto.TeamDTO;
import com.exam.dto.TeamMemberDTO;

@Repository
public class TeamDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	public int teamAdd(TeamDTO dto) {
		return session.insert("TeamMapper.teamAdd", dto);
	}
	
	public int teamMemberAdd(TeamMemberDTO dto) {
		return session.insert("TeamMapper.teamMemberAdd",dto);
	}
	
	public TeamDTO selectByPostNo(int postNo) {
		return session.selectOne("TeamMapper.selectByPostNo", postNo);
	}
}
