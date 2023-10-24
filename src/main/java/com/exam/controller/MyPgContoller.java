package com.exam.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
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
import com.exam.service.MyPgServiceImpl;

@Controller
public class MyPgContoller {

	@Autowired
	MyPgServiceImpl service;

	// 오류 때문에 화면이 아예 안 나와서 단순 화면 출력만,,,
	@GetMapping("/mypage")
	public String mypage() {
		System.out.println("mypage!!");
		return "myPage";
	}

	// 오류 때문에 화면이 아예 안 나와서 단순 화면 출력만,,,
	@GetMapping("/pgmodify")
	public String pgmodify() {
		System.out.println("mypage 수정!!");
		return "myPageEdit";
	}

	/*
	 * @GetMapping("/mypage") public String mypage(Model m) {
	 * System.out.println("mypage!!"); 
	 * 	List<MyPgDTO> list = service.selectList(); //여기서도 빨간줄 에휴
	 *  m.addAttribute("MyPgDTO", list); //이것저것 해봤는데 뭐가 맞는지 도무지,,, 다 틀렸을지도 단 한개도 맞지 않았을지도 
	 * 	return "myPage"; 
	 * }
	 */

	/*
	 * @PostMapping("/modify") public String update(MyPgDTO dto) {
	 * System.out.println("mypage 내용수정!!"); 
	 * service.update(dto); 
	 * return "myPageEdit"; 
	 * }
	 */

}
