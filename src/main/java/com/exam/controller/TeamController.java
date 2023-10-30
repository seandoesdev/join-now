package com.exam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.exam.dto.TeamDTO;
import com.exam.dto.UserInfoDTO;
import com.exam.service.TeamService;

@Controller
public class TeamController {
	@Autowired
	TeamService service;
	
	@GetMapping("/teamList")
	public String teamList(Model m, HttpSession session) {
		UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
		int userId = userInfoDTO.getId();
		List<TeamDTO> teamList = new ArrayList<TeamDTO>();
		List<Integer> teamIdList = service.selectTeamIdByUserId(userId);
		
		for(int i : teamIdList) {
			teamList.add(service.selectByTeamId(i));
		}
				
		m.addAttribute("teamList", teamList);
		return "teamList";
	}
}
