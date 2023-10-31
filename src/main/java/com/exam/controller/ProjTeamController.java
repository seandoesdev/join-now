package com.exam.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.amazonaws.auth.SdkClock.Instance;
import com.exam.dto.MeetingDTO;
import com.exam.dto.MeetingPageDTO;
import com.exam.dto.ScheduleDTO;
import com.exam.dto.TeamDTO;
import com.exam.dto.UserInfoDTO;
import com.exam.navercloud.openapi.service.ObjectStorageService;
import com.exam.service.ProjTeamServiceImpl;
import com.exam.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Controller
@Slf4j
@RequestMapping("/team")
public class ProjTeamController {

  private static final Logger log = LoggerFactory.getLogger(ProjTeamController.class);

  @Autowired
  private ProjTeamServiceImpl projTeamService;

  @Autowired
  private ObjectStorageService storageService;

  @Autowired
  private TeamService teamService;

  // 팀정보
  @GetMapping("/{teamId}")
  public String info(@PathVariable int teamId,
                     HttpSession session, Model model) {
 // loginValidation(session);
    log.info("info works");
    
    UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
    TeamDTO teamDTO = teamService.selectByTeamId(teamId);
    
    model.addAttribute("teamDTO", teamDTO);
    
    return "info";
  }

  // 일정표
  @GetMapping("/schedule/{teamId}")
  public String schedule(@PathVariable int teamId,
      HttpSession session) {
    // loginValidation(session);
    projTeamService.selectAllEventbyId();
    
    log.info("schedule works");
    return "schedule";
  }

  // 회의록
  @GetMapping("/meeting/{teamId}/{curPage}")
  public String meeting(@PathVariable int teamId,
                        @PathVariable(value = "curPage", required = false) int curPage, 
                        Model model,
                        HttpSession session) {
    // loginValidation(session);
    UserInfoDTO userInfoDTO = (UserInfoDTO)session.getAttribute("loginInfo");
    
    System.out.println("meeting test");
    HashMap<String, Integer> hashmap = new HashMap<>();
    
    hashmap.put("teamId", teamId);
//    hashmap.put("userId", userInfoDTO.getId());
    hashmap.put("curPage", curPage);
    
    MeetingPageDTO pageDTO = projTeamService.getAllPost(hashmap);
    model.addAttribute("pageDTO", pageDTO);
    model.addAttribute("teamId", teamId);
    return "meeting";
  }

  // 회의록 작성 페이지
  @GetMapping("/meeting/write/{teamId}")
  public String meetingWrite(@PathVariable int teamId, HttpSession session, Model model) {
    // loginValidation(session);
    model.addAttribute("teamId", teamId);
    return "meetingWrite";
  }

  ////////////////////
  ////// 기능 구현 //////
  ///////////////////
  
  /**
   * 일정표 기능 구현
   */

  // 일정표 - 이벤트 조회 기능
  @GetMapping("/schedule/select/event")
  public @ResponseBody List<ScheduleDTO> select() {
    return projTeamService.selectAllEventbyId();
  }

  // 일정표 - 이벤트 추가 기능
  @PostMapping("/schedule/add/event")
  public String saveEvent(@RequestBody List<ScheduleDTO> scheduleDTO) {
    System.out.println("event insert test");
    for (final ScheduleDTO dto : scheduleDTO) {
      System.out.println(dto.getTitle());
    }
    int n = projTeamService.insertEvent(scheduleDTO);

    return "schedule";
  }

  // 일정표 - 이벤트 수정 기능
  @PostMapping("/schedule/update/event")
  public String updateEvent(@RequestBody ScheduleDTO scheduleDTO) {
    System.out.println("event update test");
    try {
      projTeamService.updateEvent(scheduleDTO);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return "schedule";
  }

  // 일정표 - 이벤트 삭제 기능
  @PostMapping("/schedule/delete/event")
  public String deleteEvent(@RequestBody ScheduleDTO scheduleDTO) {
    System.out.println("event delete test");
    return "schedule";
  }


  /**
   * 희의록 기능
   */

  // 회의록 작성
  @GetMapping("/meeting/write.do/{teamId}")
  public String addMeeeting(@PathVariable int teamId,
                            @ModelAttribute MeetingDTO meetingDTO, HttpSession session) {
    // loginValidation(session);
    UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
    meetingDTO.setTeamId(teamId);
    meetingDTO.setWriter(userInfoDTO.getNickname());

    System.out.println("meetingWrite test");
    System.out.println(meetingDTO.getTitle());
    projTeamService.addMeetingPost(meetingDTO);
    return "meetingWrite";
  }

  /**
   * 구현해야 할 사항 teamId 값을 @PathVariable로 쿼리 파라미터로 받아와서 teamId, id 값을 map에 넣은 후 서비스로 전달
   */
  // 회의록 상세페이지
  @GetMapping("/meeting/detail/{teamId}/{meetingNo}")
  public String meetingDetail(@PathVariable int teamId, @PathVariable int meetingNo,
      HttpSession session, Model model) {

    HashMap<String, Integer> map = new HashMap<>();
    map.put("teamId", teamId);
    map.put("meetingNo", meetingNo);

    System.out.println("meeting detail test");

    MeetingDTO meetingDTO = projTeamService.selectOneById(map);
    meetingDTO.setMeetingNo(meetingNo);
    meetingDTO.setTeamId(teamId);
    model.addAttribute("meetingDTO", meetingDTO);

    return "meetingDetail";
  }

  // 회의록 삭제
  @GetMapping("/meeting/delete/{teamId}/{meetingNo}")
  public String meetingDelete(@PathVariable int teamId, @PathVariable int meetingNo,
      HttpSession session) {

    HashMap<String, Integer> map = new HashMap<>();
    map.put("teamId", teamId);
    map.put("meetingNo", meetingNo);

    projTeamService.deleteOneById(map);

    return "meeting";
  }

  // 회의록 수정페이지
  @GetMapping("/meeting/retrieve/{teamId}/{meetingNo}")
  public String meetingRetrieve(@PathVariable int teamId, @PathVariable int meetingNo,
      HttpSession session, Model model) {

    HashMap<String, Integer> map = new HashMap<>();
    map.put("teamId", teamId);
    map.put("meetingNo", meetingNo);

    System.out.println("meeting retrieve test");

    MeetingDTO meetingDTO = projTeamService.selectOneById(map);
  
    model.addAttribute("meetingDTO", meetingDTO);

    return "meetingRetrieve";
  }
  
//회의록 수정 기능
 @GetMapping("/meeting/retrieve.do/{teamId}/{meetingNo}")
 public String meetingRetrieveDo(@PathVariable int teamId, @PathVariable int meetingNo,
                                 MeetingDTO meetingDTO, HttpSession session) {

   HashMap<String, Object> map = new HashMap<>();
   map.put("teamId", teamId);
   map.put("meetingNo", meetingNo);
   map.put("meetingDTO", meetingDTO);

   System.out.println("meeting retrieve test");
   System.out.println(meetingDTO.getTitle());
   projTeamService.updateMeetingById(map);

   return "meetingRetrieve";
 }



  /**
   * 
   * @param model
   * @return
   */

  // project/info
  @GetMapping("/info/team-intro")
  public String selectAllbyId(Model model) {
    return "info";
  }

  // 로그인 확인
  private String loginValidation(HttpSession session) {
    if (session.getAttribute("loginInfo") == null) {
      return "redirect:/main";
    }
    return "";
  }

}
