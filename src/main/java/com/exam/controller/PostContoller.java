package com.exam.controller;

import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.dto.ApplyDTO;
import com.exam.dto.PostDTO;
import com.exam.service.ApplyService;
import com.exam.service.PostServiceImpl;

@Controller
public class PostContoller {

	@Autowired
	PostServiceImpl service;
	
	@Autowired
	ApplyService applyService;

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
	public String noticeAdd(PostDTO dto, @RequestParam String category) {
		int n = service.postAdd(dto);
		StringTokenizer st = new StringTokenizer(category, ",");
		while(st.hasMoreElements()) {
			String category1 = st.nextToken();
			String category2 = st.nextToken();
			dto.setCategory1(category1);
			dto.setCategory2(category2);
		}
		System.out.println(dto.toString());
		
		return "redirect:postMain";
	}

	// 게시글 자세히보기 화면
	@GetMapping("/retrieve")
	public String postRetrieve(Model m, @RequestParam int postNo) {
		List<PostDTO> list = service.postList();
		PostDTO dto = service.postListbyNo(postNo);
		int n = service.viewCount(postNo);
		m.addAttribute("postListbyNum", dto);
		m.addAttribute("postList", list);
		return "retrieve";

	}

	// 게시글 업데이트 화면 UI
	@GetMapping("/updateUI")
	public String updateUI(Model m, @RequestParam int postNo) {
		List<PostDTO> list = service.postList();
		PostDTO dto = service.postListbyNo(postNo);
		m.addAttribute("postListbyNum", dto);
		m.addAttribute("postList", list);
		return "updateForm";

	}

	// 게시글 업데이트 화면
	@PostMapping("/update")
	public String postUpdate(PostDTO dto) {
		int n = service.postUpdate(dto);
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
		public String postApply(ApplyDTO dto) {
			int n = applyService.applyAdd(dto);
			return "redirect:postMain";
		}
		

}
