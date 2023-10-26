package com.exam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.Position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpLogging;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.dto.AcceptDTO;
import com.exam.dto.ApplyDTO;
import com.exam.dto.CommentDTO;
import com.exam.dto.PositionDTO;
import com.exam.dto.PostDTO;
import com.exam.dto.UserInfoDTO;
import com.exam.service.AcceptService;
import com.exam.service.ApplyService;
import com.exam.service.CommentService;
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
	
	@Autowired
	AcceptService acceptService;
	
	@Autowired
	CommentService commentService;

	@GetMapping("/postMain")
	public String main(Model m) {
		List<PostDTO> list = service.postList();
		m.addAttribute("postList", list);
		return "postMain";
	}

	// 게시글작성화면
	@GetMapping("/write")
	public String postAddForm(Model m, HttpServletRequest request) {
		HttpSession session = request.getSession();
		return "writeForm";
	}

//	// 삽입하기
//	@PostMapping("/postAdd")
//	public String postAdd(PostDTO dto, PositionDTO dto2, HttpSession session) {
//		
//		//List로 반환된 position정보를 split함
//		//postNo는 값 없음.
//		List<PositionDTO> list = positionSplit(dto2);
//
//		//post & position 삽입
//		//split한 데이터 insert
//		int n = positionService.positionAdd(dto, list);
////		int n = positionService.positionAdd(postNo, dto, dto2);
//		
//		//이전 데이터
//		//postNo정보 가지고 옴
////		int postNo = dto.getPostNo();
////		positionService.positionAdd(postNo, dto, dto2);
////		ResponseEntity.ok("Data inserted successfully.");
//		
//		//로그인 정보 확인
//		UserInfoDTO userInfoDTO = (UserInfoDTO)session.getAttribute("loginInfo");
//		dto.setUserid(userInfoDTO.getId());
//		System.out.println("postAdd:"+dto);
//		
//		return "redirect:postMain";
//	}
	
	@PostMapping("/postAdd")
	public String postAdd(PostDTO dto, PositionDTO dto2, HttpSession session) {
		UserInfoDTO userInfoDTO = (UserInfoDTO)session.getAttribute("loginInfo");
		//List로 반환된 position정보를 split함
		//postNo는 값 없음.
		List<PositionDTO> list = positionSplit(dto2);
		//post & position 삽입
		//split한 데이터 insert
		dto.setUserid(userInfoDTO.getId());
		System.out.println(dto);
		int n = positionService.positionAdd(dto, list);
//		int n = positionService.positionAdd(postNo, dto, dto2);
		
		//이전 데이터
		//postNo정보 가지고 옴
//		int postNo = dto.getPostNo();
//		positionService.positionAdd(postNo, dto, dto2);
//		ResponseEntity.ok("Data inserted successfully.");
		
		
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
		System.out.println("updateUI:" + dto);
		return "updateForm";

	}

	// 게시글 업데이트 화면
	@PostMapping("/update")
	public String postUpdate(PostDTO dto, PositionDTO dto2) {
		//position부분을 제외한 
		int n = service.postUpdate(dto);
		
//		int n2 = positionService.positionUpdate(dto2);
		
		//기존 데이터 삭제
		//postNo에 맞는 데이터 deleteAll
		int n2 = positionService.positionDelete(dto.getPostNo());
		
		//함수 사용해서 insert처리
		List<PositionDTO> list = positionSplit(dto2);
		//insert처리
		//update하면 맨 마지막 변수만 저장이 되어 아예 삭제하고 재삽입.
		for(PositionDTO pd:list) {
			System.out.println("update:"+pd);
			positionService.positionOneAdd(pd);
		}
		
		return "redirect:postMain";
	}

	// 게시글 삭제
	@PostMapping("/delete")
	public String postDelete(int postNo) {
		int n = service.postDelete(postNo);
		return "redirect:postMain";
	}

	// 지원하기 화면
	@PostMapping("/apply")
	public String postApply(ApplyDTO dto, HttpSession session, int postNo) {
		PostDTO postDTO = service.postListbyNo(postNo);
		System.out.println("apply:"+postDTO);
		
		//apply 테이블 정보 저장
		UserInfoDTO userInfoDTO = (UserInfoDTO)session.getAttribute("loginInfo");
		dto.setUserid(userInfoDTO.getId());
		int n = applyService.applyAdd(dto); 
		
		//accept 테이블 정보 저장
		AcceptDTO acceptDTO = new AcceptDTO();
		acceptDTO.setAcceptUserId(postDTO.getUserid()); //작성자
		acceptDTO.setApplyUserId(dto.getUserid()); //신청자
		acceptDTO.setAccept(false); //수락 여부
		acceptDTO.setPostNo(postDTO.getPostNo()); //게시판 정보
		System.out.println(acceptDTO);
		int n2 = acceptService.acceptAdd(acceptDTO);
		return "redirect:postMain";
	}

	// position data split method
	public List<PositionDTO> positionSplit(PositionDTO dto) {
		List<PositionDTO> list = new ArrayList<PositionDTO>();
		int postNo = dto.getPostNo();
		//구분자로 나눠줌
	    String[] categorySplit = dto.getCategory().split(",");
	    String[] recruitTypeSplit = dto.getRecruitType().split(",");
	    String[] memberSizeSplit = dto.getMemberSize().split(",");

	    int numValues = Math.min(categorySplit.length, Math.min(recruitTypeSplit.length, memberSizeSplit.length));

	    for (int i = 0; i < numValues; i++) {

	        PositionDTO position = new PositionDTO(postNo,categorySplit[i],recruitTypeSplit[i],memberSizeSplit[i]);
	        list.add(position);
	        
	    }
	    return list;
	}
	
	// 댓글 출력
		@GetMapping(value="/commentList")
		@ResponseBody
		public List<CommentDTO> commentList(@RequestParam int postNo) {
			//댓글정보 출력
			List<CommentDTO> list = commentService.commentListbyNo(postNo);
			System.out.println("commentAdd:" + list);
			return list;
		}
		
		// 댓글 저장
			@PostMapping(value="/commentAdd")
			@ResponseBody
			public String commentAdd(@RequestBody CommentDTO dto, HttpSession session) {
				// 댓글정보 생성
				UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
				dto.setWriter(userInfoDTO.getId());
				int n = commentService.commentAdd(dto);
				System.out.println("commentAdd:" + dto);
				//댓글정보 출력
				List<CommentDTO> list = commentService.commentListbyNo(dto.getPostNo());
				System.out.println("commentAdd:" + list);
				return "ok";
			}

}
