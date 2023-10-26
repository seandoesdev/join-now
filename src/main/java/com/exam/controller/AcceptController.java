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
	
	@GetMapping("/applyPage")
	public String applyPage(Model m, HttpSession session) {
		// 로그인 정보 확인
		UserInfoDTO userInfoDTO = (UserInfoDTO)session.getAttribute("loginInfo");
		// 로그인 유저 아이디와 신청자 id를 비교해서 리스트를 들고옴 -> 신청자 내역확인
		List<AcceptDTO> acceptDTOList = acceptService.selectListApplyUser(userInfoDTO.getId());
		
		// 콘솔에 신청자 정보 출력
		System.out.println("########################");
		for(AcceptDTO acceptdto : acceptDTOList) {
			System.out.println(acceptdto);
		}
		
		// 출력 dto를 가진 리스트 생성
		List<AcceptPrintDTO> acceptPrintList = new ArrayList<>();
		
		// 출력 dto를 가진 리스트에 값저장 acceptDTOList에 있는 정보를 accpetdto에 저장해서 그 정보를 바탕으로 이용해서
		// 출력 dto에 신청자, 작성자, 게시판 정보, 신청 정보 저장
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
		
		return "applyPage";
	}
	
	@GetMapping("/acceptPage")
	public String acceptPage(Model m, HttpSession session) {
		// 로그인 정보 확인
		UserInfoDTO userInfoDTO = (UserInfoDTO)session.getAttribute("loginInfo");
		// 로그인 유저 아이디와 작성자 id를 비교해서 리스트를 들고옴 -> 작성자가 받은 신청자 내역확인
		List<AcceptDTO> acceptDTOList = acceptService.selectListAcceptUser(userInfoDTO.getId());
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
