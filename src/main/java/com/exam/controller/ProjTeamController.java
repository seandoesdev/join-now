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
import com.exam.dto.ProjDTO;
import com.exam.dto.QuestionDTO;
import com.exam.dto.ScheduleDTO;
import com.exam.dto.TestDTO;
import com.exam.dto.UserInfoDTO;
import com.exam.service.ProjTeamServiceImpl;
import lombok.extern.slf4j.Slf4j;



@Controller
@Slf4j
@RequestMapping("/team")
public class ProjTeamController {



  @Autowired
  ProjTeamServiceImpl service;

  @GetMapping("/test")
  public String test(HttpSession session) {
    UserInfoDTO dto = (UserInfoDTO) session.getAttribute("loginInfo");
    System.out.println(dto);
    return "schedule";
  }

  // 팀정보
  @GetMapping("/")
  public String info() {
    System.out.println("info test");
    return "info";
  }

  // 일정표
  @GetMapping("/schedule")
  public String schedule() {
    System.out.println("schedule test");
    return "schedule";
  }

  // 회의록
  @GetMapping("/meeting")
  public String meeting() {
    System.out.println("meeting test");
    return "meeting";
  }

  // 회의록 작성 페이지
  @GetMapping("/meeting/write")
  public String meetingWrite(Model model) {
    
    model.addAttribute(attributeName, attributeValue);
    return "meetingWrite";
  }



  ////// 기능 구현 //////

  /**
   * 일정표 기능 구현
   */

  // 일정표 - 이벤트 조회 기능
  @PostMapping("/schedule/select/event")
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
  
  @PostMapping("/meeting/")

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
    ProjDTO pdto = service.selectAllbyId();
    model.addAttribute("subject", pdto.getId());
    model.addAttribute("", pdto.getId());
    return "info";
  }



}
