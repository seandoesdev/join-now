package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.TeamDAO;
import com.exam.dto.TeamDTO;
import com.exam.dto.TeamMemberDTO;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamDAO dao;

	@Override
	public int teamAdd(TeamDTO dto) {
		return dao.teamAdd(dto);
	}

	@Override
	public int teamMemberAdd(TeamMemberDTO dto) {
		return dao.teamMemberAdd(dto);
	}

	@Override
	public TeamDTO selectByPostNo(int postNo) {
		return dao.selectByPostNo(postNo);
	}
	

	@Override
	public List<Integer> selectTeamIdByUserId(int userId) {
		return dao.selectTeamIdByUserId(userId);
	}

	@Override
	public TeamDTO selectByTeamId(int teamId) {
		return dao.selectByTeamId(teamId);
	}
	
	
}
