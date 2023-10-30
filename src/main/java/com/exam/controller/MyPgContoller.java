package com.exam.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.dto.MyPgDTO;
import com.exam.dto.UserInfoDTO;
import com.exam.service.MyPgServiceImpl;
import com.exam.service.UserService;
import com.exam.service.UserServiceImpl;

@Controller
public class MyPgContoller {

	@Autowired
	MyPgServiceImpl myService;
	
	@Autowired
	UserServiceImpl userService;

	//로그인 후 mypage 요청하면 이메일만 출력
	@GetMapping("/mypage")
	public String mypage(Model m, HttpSession session) {
		System.out.println("mypage!!");
	
		//세션에서 id값 받아오기
		UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
		int id = userInfoDTO.getId();
		//현재 로그인된 id에 해당하는 정보 받아와서 출력
		UserInfoDTO info = userService.selectAllById(id);
		m.addAttribute("UserInfoDTO", info);

		return "myPage";
	}
	
	// 마이페이지 수정 페이지 들어가기
	@GetMapping("/insertui")
	public String mypageInsert(Model m, HttpServletRequest request) {
		HttpSession session = request.getSession();
		return "myPageAdd";
	}

	// mypage 수정
	@PostMapping("/myinsert") 
	  public String mypageInsert(MyPgDTO dto, HttpSession session) {
	  System.out.println("mypage 내용추가!!"); 
	  UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
	  int n = userInfoDTO.getId();	
	  
	  //dto에 사용자 id 설정
	  dto.setId(userInfoDTO.getId());
	  int n2 = myService.mypageUpdate(dto);	// insert -> Update로 변경
	  
	  return "redirect:mypage"; 
	}

	 
}
