package com.exam.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.exam.dto.TeamDTO;
import com.exam.dto.MeetingDTO;
import com.exam.dto.MeetingPageDTO;
import com.exam.dto.ScheduleDTO;
import com.exam.dto.TestDTO;
import com.exam.dto.UserInfoDTO;
import com.exam.service.ProjTeamServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Controller
@Slf4j
@RequestMapping("/team")
public class ProjTeamController {

  private static final Logger log = LoggerFactory.getLogger(ProjTeamController.class);

  @Autowired
  ProjTeamServiceImpl service;

  @GetMapping("/test")
  public String test(HttpSession session) {
    UserInfoDTO dto = (UserInfoDTO) session.getAttribute("loginInfo");
    log.info("");
    return "schedule";
  }

  // 팀정보
  @GetMapping("/")
  public String info(HttpSession session, Model model) {
    if (session.getAttribute("loginInfo") == null) {
      model.addAttribute("alertMessage", "로그인 후 이용 가능합니다.");
      return "redirect:/main";
    }
    log.info("info works");
    return "info";
  }

  // 일정표
  @GetMapping("/schedule")
  public String schedule(HttpSession session) {
    if (session.getAttribute("loginInfo") == null) {
      return "redirect:/main";
    }
    log.info("schedule works");
    return "schedule";
  }

  // 회의록
  @GetMapping("/meeting")
  public String meeting(@RequestParam(value = "curPage", required = false, defaultValue = "1")int curPage,
      Model model) {
    System.out.println("meeting test");
    viewPost(curPage, model);
    return "meeting";
  }

  // 회의록 작성 페이지
  @GetMapping("/meeting/write")
  public String meetingWrite(Model model) {
    
//    model.addAttribute(attributeName, attributeValue);
    return "meetingWrite";
  }



  ////// 기능 구현 //////

  /**
   * 일정표 기능 구현
   */

  // 일정표 - 이벤트 조회 기능
  @GetMapping("/schedule/select/event")
  public @ResponseBody List<ScheduleDTO> select() {
    return service.selectAllEventbyId();
  }

  // 일정표 - 이벤트 추가 기능
  @PostMapping("/schedule/add/event")
  public String saveEvent(@RequestBody List<ScheduleDTO> scheduleDTO) {
    System.out.println("event insert test");
    for (final ScheduleDTO dto : scheduleDTO) {
      System.out.println(dto.getTitle());
    }
    int n = service.insertEvent(scheduleDTO);

    return "schedule";
  }

  // 일정표 - 이벤트 수정 기능
  @PostMapping("/schedule/update/event")
  public String updateEvent(@RequestBody ScheduleDTO scheduleDTO) {
    System.out.println("event update test");
    try {
      service.updateEvent(scheduleDTO);
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
  
  
  
  // 회의록 - 목록 보기
  // 회의록 - 목록 보기
  public void viewPost(int curPage, Model model) {
    MeetingPageDTO pageDTO = service.getAllPost(curPage);
    model.addAttribute("pageDTO", pageDTO);
  }

  // 회의록 작성
  @GetMapping("/meeting/write/do")
  public String addMeeeting(Model model) {
    System.out.println("meetingWrite test");
    return "meetingWrite";
  }



  /**
   * 
   * @param model
   * @return
   */

  // project/info
  @GetMapping("/info/team-intro")
  public String selectAllbyId(Model model) {
    TeamDTO pdto = service.selectAllbyId();
    model.addAttribute("subject", pdto.getId());
    model.addAttribute("", pdto.getId());
    return "info";
  }



}
