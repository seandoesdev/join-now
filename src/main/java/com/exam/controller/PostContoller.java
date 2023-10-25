package com.exam.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.text.Position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.dto.ApplyDTO;
import com.exam.dto.PositionDTO;
import com.exam.dto.PostDTO;
import com.exam.dto.UserInfoDTO;
import com.exam.service.ApplyService;
import com.exam.service.PositionService;
import com.exam.service.PostServiceImpl;

@Controller
public class PostContoller {

	@Autowired
	PostServiceImpl service;
	
	@Autowired
	ApplyService applyService;
	
	@Autowired
	PositionService positionService;

	@GetMapping("/postMain")
	public String main(Model m) {
		List<PostDTO> list = service.postList();
		m.addAttribute("postList", list);
		return "postMain";
	}

	// 게시글작성화면
	@GetMapping("/write")
	public String postAddForm(Model m) {
		return "writeForm";
	}

	
	// 삽입하기
	@PostMapping("/postAdd")
	public String postAdd(PostDTO dto, PositionDTO dto2) {
			
			int postNo = dto.getPostNo();
			positionService.positionAdd(postNo, dto, dto2);
			ResponseEntity.ok("Data inserted successfully.");
			
			System.out.println(dto2.toString());
			    
			return "redirect:postMain";
		}
		    

	// 게시글 자세히보기 화면
	@GetMapping("/retrieve")
	public String postRetrieve(Model m, @RequestParam int postNo) {
		List<PostDTO> list = service.postList();
		PostDTO postDTO = service.postListbyNo(postNo);
		int n = service.viewCount(postNo);
		List<PositionDTO> positionList = positionService.positionList(postNo);
		m.addAttribute("postListbyNum", postDTO);
		m.addAttribute("postList", list);
		m.addAttribute("positionList", positionList);
		return "retrieve";
	}

	// 게시글 업데이트 화면 UI
	@GetMapping("/updateUI")
	public String updateUI(Model m, @RequestParam int postNo) {
		List<PostDTO> list = service.postList();
		PostDTO dto = service.postListbyNo(postNo);
		List<PositionDTO> positionList = positionService.positionList(postNo);
		m.addAttribute("postListbyNum", dto);
		m.addAttribute("postList", list);
		m.addAttribute("positionList", positionList);
		System.out.println(dto);
		return "updateForm";

	}

	// 게시글 업데이트 화면
	@PostMapping("/update")
	public String postUpdate(PostDTO dto, PositionDTO dto2) {
		int n = service.postUpdate(dto);
		int n2 = positionService.positionUpdate(dto2);
		return "redirect:postMain";
	}
	
	//게시글 삭제
	@PostMapping("/delete")
	public String postDelete(int postNo) {
		int n = service.postDelete(postNo);
		return "redirect:postMain";
	}
	
	//지원하기 화면
		@PostMapping("/apply")
		public String postApply(ApplyDTO dto, HttpSession session ) {
			
			UserInfoDTO userInfoDTO = (UserInfoDTO)session.getAttribute("loginInfo"); 
			dto.setUserid(userInfoDTO.getId());			
						
			int n = applyService.applyAdd(dto);
			return "redirect:main";
		}
		

}
