package com.exam.service;

import com.exam.dto.TeamDTO;
import com.exam.dto.TeamMemberDTO;

public interface TeamService {
	public int teamAdd(TeamDTO dto);
	public int teamMemberAdd(TeamMemberDTO dto);
	public TeamDTO selectByPostNo(int postNo);
}
