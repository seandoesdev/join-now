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
import org.springframework.web.bind.annotation.ResponseBody;
import com.exam.dto.ProjDTO;
import com.exam.dto.QuestionDTO;
import com.exam.dto.ScheduleDTO;
import com.exam.dto.TestDTO;
import com.exam.service.ProjTeamServiceImpl;



@Controller
@RequestMapping("/team")
public class ProjTeamController {



  @Autowired
  ProjTeamServiceImpl service;

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
