package com.exam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.dto.AcceptDTO;
import com.exam.dto.AcceptPrintDTO;
import com.exam.dto.UserInfoDTO;
import com.exam.service.AcceptService;
import com.exam.service.PostService;
import com.exam.service.UserService;

@Controller
public class AcceptController {
		
	@Autowired
	AcceptService acceptService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/acceptPage")
	public String acceptPage(Model m, HttpSession session) {
		UserInfoDTO userInfoDTO = (UserInfoDTO)session.getAttribute("loginInfo");
		List<AcceptDTO> acceptDTOList = acceptService.selectListApplyUser(userInfoDTO.getId());
		System.out.println("########################");
		for(AcceptDTO acceptdto : acceptDTOList) {
			System.out.println(acceptdto);
		}
				
		List<AcceptPrintDTO> acceptPrintList = new ArrayList<>();
		
		for(AcceptDTO acceptdto : acceptDTOList) {
			AcceptPrintDTO printdto = new AcceptPrintDTO();
			printdto.setAcceptDTO(acceptdto);
			printdto.setAcceptUserInfoDTO(userService.selectAllById(acceptdto.getAcceptUserId()));
			printdto.setApplyUserInfoDTO(userService.selectAllById(acceptdto.getApplyUserId()));
			printdto.setPostDTO(postService.postListbyNo(acceptdto.getPostNo()));
			
			acceptPrintList.add(printdto);
		}
		
		for(AcceptPrintDTO printdto : acceptPrintList) {
			System.out.println(printdto);
		}
		
		m.addAttribute("acceptPrintList",acceptPrintList);
		
		return "acceptPage";
	}
}
