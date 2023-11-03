package com.exam.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.exam.dto.NotificationDTO;
import com.exam.dto.PositionDTO;
import com.exam.dto.PostDTO;
import com.exam.dto.TeamDTO;
import com.exam.dto.TeamMemberDTO;
import com.exam.dto.UserInfoDTO;
import com.exam.service.AcceptService;
import com.exam.service.ApplyService;
import com.exam.service.CommentService;
import com.exam.service.NotificationService;
import com.exam.service.PositionService;
import com.exam.service.PostServiceImpl;
import com.exam.service.TeamService;

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
	
	@Autowired
	TeamService teamService;
	
	@Autowired
	NotificationService notificationService;
	
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
		UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
		// List로 반환된 position정보를 split함
		// postNo는 값 없음.
		List<PositionDTO> list = positionSplit(dto2);
		// post & position 삽입
		// split한 데이터 insert
		dto.setUserid(userInfoDTO.getId());
		dto.setNickname(userInfoDTO.getNickname());
		int n = positionService.positionAdd(dto, list);
		
		// 게시물 작성시 팀 정보 테이블 생성
		TeamDTO teamDTO = new TeamDTO();
		teamDTO.setPostNo(n);
		teamDTO.setUserId(userInfoDTO.getId());
		int n2 = teamService.teamAdd(teamDTO);
		
				
		TeamMemberDTO teamMemberDTO = new TeamMemberDTO();
		teamMemberDTO.setTeamId(teamDTO.getTeamId());
		teamMemberDTO.setUserId(userInfoDTO.getId());
		int n3 = teamService.teamMemberAdd(teamMemberDTO);
		
//		int n = positionService.positionAdd(postNo, dto, dto2);		
		//이전 데이터
		//postNo정보 가지고 옴
//		int postNo = dto.getPostNo();
//		positionService.positionAdd(postNo, dto, dto2);
//		ResponseEntity.ok("Data inserted successfully.");

		return "redirect:main";
	}

	// 게시글 자세히보기 화면
	@GetMapping("/retrieve")
	public String postRetrieve(Model m, @RequestParam int postNo,HttpSession session, HttpServletRequest request) {
		UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
		int LoggedInId = userInfoDTO.getId(); //로그인한 아이디
		List<PostDTO> list = service.postList();
		PostDTO postDTO = service.postListbyNo(postNo);
		int author = postDTO.getUserid(); //게시글 작성자 아이디
		int n = service.viewCount(postNo);
		List<PositionDTO> positionList = positionService.positionList(postNo);
		m.addAttribute("postListbyNum", postDTO);
		m.addAttribute("postList", list);
		m.addAttribute("positionList", positionList);
		request.setAttribute("LoggedInId", LoggedInId);
		request.setAttribute("author", author);
		System.out.println("retrieve:"+postDTO);
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
	public String postUpdate(PostDTO dto, PositionDTO dto2, HttpSession session) {
		//작성자 아이디 확인
		UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
		dto.setUserid(userInfoDTO.getId());
		
		// position부분을 제외한
		int n = service.postUpdate(dto);

//		int n2 = positionService.positionUpdate(dto2);

		// 기존 데이터 삭제
		// postNo에 맞는 데이터 deleteAll
		int n2 = positionService.positionDelete(dto.getPostNo());

		// 함수 사용해서 insert처리
		List<PositionDTO> list = positionSplit(dto2);
		// insert처리
		// update하면 맨 마지막 변수만 저장이 되어 아예 삭제하고 재삽입.
		for (PositionDTO pd : list) {
			System.out.println("update:" + pd);
			positionService.positionOneAdd(pd);
		}

		return "redirect:main";
	}

	// 게시글 삭제
	@PostMapping("/delete")
	public String postDelete(int postNo, HttpSession session) {
		UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
		int loginedId = userInfoDTO.getId(); //로그인한 아이디
		HashMap<String, Object> map = new HashMap<>();
		map.put("postNo", postNo);
		map.put("userid", loginedId);
		int n = service.postDelete(map);
		return "redirect:main";
	}

	// 지원하기 화면
	@PostMapping("/apply")
	public String postApply(ApplyDTO dto, HttpSession session, int postNo) {
		PostDTO postDTO = service.postListbyNo(postNo);
		System.out.println("apply:" + postDTO);

		// apply 테이블 정보 저장
		UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
		dto.setUserid(userInfoDTO.getId());
		int n = applyService.applyAdd(dto);
		System.out.println("*************" + dto.getApplyNo());

		// accept 테이블 정보 저장
		AcceptDTO acceptDTO = new AcceptDTO();
		acceptDTO.setAcceptUserId(postDTO.getUserid()); // 작성자
		acceptDTO.setApplyUserId(dto.getUserid()); // 신청자
		acceptDTO.setAccept(false); // 수락 여부
		acceptDTO.setPostNo(postDTO.getPostNo()); // 게시판 정보
		acceptDTO.setApplyNo(dto.getApplyNo()); // 신청서 정보
		System.out.println(acceptDTO);
		int n2 = acceptService.acceptAdd(acceptDTO);


		// 알림 전송
		NotificationDTO notificationDTO = new NotificationDTO();
		notificationDTO.setSendId(dto.getUserid()); // 신청자
		notificationDTO.setReceiveId(postDTO.getUserid()); // 작성자
		notificationDTO.setContent("지원 신청 하였습니다.");
		notificationDTO.setPostId(postDTO.getPostNo()); // 공고 정보
		
		notificationService.notificationAdd(notificationDTO);

		return "redirect:main";

	}

	// position data split method
	public List<PositionDTO> positionSplit(PositionDTO dto) {
		List<PositionDTO> list = new ArrayList<PositionDTO>();
		int postNo = dto.getPostNo();
		// 구분자로 나눠줌
		String[] categorySplit = dto.getCategory().split(",");
		String[] recruitTypeSplit = dto.getRecruitType().split(",");
		String[] memberSizeSplit = dto.getMemberSize().split(",");

		int numValues = Math.min(categorySplit.length, Math.min(recruitTypeSplit.length, memberSizeSplit.length));

		for (int i = 0; i < numValues; i++) {

			PositionDTO position = new PositionDTO(postNo, categorySplit[i], recruitTypeSplit[i], memberSizeSplit[i]);
			list.add(position);

		}

		return list;
	}

	// 페이지별 댓글 출력
	@GetMapping("/commentList")
	@ResponseBody
	public List<CommentDTO> commentList(@RequestParam int postNo) {
		// 댓글정보 출력
		List<CommentDTO> list = commentService.commentListbyNo(postNo);
		return list;
	}
	
	//댓글 수정을 위한 고유번호별 댓글 출력
	@GetMapping("/commentListbyCno")
	@ResponseBody
	public CommentDTO commentListbyCno(@RequestParam int commentNo, HttpSession session, Model m) {
		//로그인 정보 확인
		UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
		// 댓글정보 출력
		CommentDTO commentDTO = commentService.commentListbyCno(commentNo);
		int id = userInfoDTO.getId();
		commentDTO.setWriter(id);
		System.out.println("commentListbyCno:" + commentDTO);
		m.addAttribute("id", id);
		return commentDTO;
	}

	// 댓글 저장
	@PostMapping("/commentAdd")
	@ResponseBody
	public String commentAdd(@RequestBody CommentDTO dto, HttpSession session) {
		// 댓글정보 생성
		UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
		dto.setWriter(userInfoDTO.getId()); 	// 인덱스값인 id를 가져온다.
		dto.setNickname(userInfoDTO.getNickname());
		int n = commentService.commentAdd(dto);
		return "ok";
	}

	// 댓글 수정
	@PostMapping("/commentUpdate")
	@ResponseBody
	public String commentUpdate(@RequestBody CommentDTO dto) {
		int n = commentService.commentUpdate(dto);
		return "updated";
	}

	// 댓글 삭제
	@PostMapping("/commentDelete")
	@ResponseBody
	public int commentDelete(@RequestBody CommentDTO dto, HttpSession session, Model m) {
		UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
		int id = userInfoDTO.getId();
		dto.setWriter(id);
		int n = commentService.commentDelete(dto.getCommentNo());
		m.addAttribute("id", id);
		return id;
	}
	
	// 작성자가 작성한 게시물 리스트 출력
	@GetMapping("/writeList")
	public String writeList(Model m, HttpSession session) {
		UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
		int userId = userInfoDTO.getId();
		
		m.addAttribute("writeList", service.postListbyId(userId));
		
		return "writeList";
	}
	

}
