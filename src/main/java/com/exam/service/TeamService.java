package com.exam.service;

import java.util.List;

import com.exam.dto.TeamDTO;
import com.exam.dto.TeamMemberDTO;

public interface TeamService {
	public int teamAdd(TeamDTO dto);
	public int teamMemberAdd(TeamMemberDTO dto);
	public TeamDTO selectByPostNo(int postNo);
	public TeamDTO selectByTeamId(int teamId);

	public List<Integer> selectTeamIdByUserId(int userId);
	public List<TeamMemberDTO> selectMemberListByTeamId(int teamId);
	public int teamMemberDel(int userId);
}
