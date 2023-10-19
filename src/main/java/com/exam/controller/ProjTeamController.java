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
import com.exam.dto.ProjDTO;
import com.exam.dto.QuestionDTO;
import com.exam.dto.ScheduleDTO;
import com.exam.dto.TestDTO;
import com.exam.service.ProjTeamServiceImpl;




@Controller
@RequestMapping("/project")
public class ProjTeamController {

  
      
  @Autowired
  ProjTeamServiceImpl service;
  
  @GetMapping("/testdb")
  public String testdb() {
    System.out.println("testdb test");
    System.out.println(service.testSelect());
    return "main";
  }

  @GetMapping("/index")
  public String index() {
    System.out.println("index test");
    return "index";
  }
  
  @GetMapping("/question")
  public String question() {
    System.out.println("question test");
    return "question";
  }
  
  // QnA 작성하는 부분
  @GetMapping("/question/write")
  public String createPost(@RequestBody QuestionDTO questionDTO) {
    try {
        // 받은 데이터를 사용하여 게시물 생성
        service.createPost(questionDTO);
        return "question";
    } catch (Exception e) {
        return "게시물 작성 중 오류가 발생했습니다.";
    }
}
  
  // schedule
  @GetMapping("/schedule")
  public String test() {
    System.out.println("schedule test");
    return "schedule";
  }
  
  @GetMapping("/meeting")
  public String meeting() {
    System.out.println("meeting test");
    return "meeting";
  }
  
  @GetMapping("/info")
  public String info() {
    System.out.println("info test");
    return "info";
  }
  
  @GetMapping("/notice")
  public String notice() {
    System.out.println("notice test");
    return "notice";
  }
  

  
  
  // schedule add a new event 
  @PostMapping("/schedule/addEvent")
  public String insertSch(@RequestBody ScheduleDTO scheduleDTO) {
    System.out.println(scheduleDTO);
    return "schedule";
  }
  
  
  // project/info
  @GetMapping("/info/team-intro")
  public String selectAllbyId(Model model) {
    ProjDTO pdto = service.selectAllbyId();
    model.addAttribute("subject", pdto.getId());
    model.addAttribute("", pdto.getId());
    return "info";
  }
  

  @GetMapping("/question/write/do")
  public String qnaWriteDo() {
    System.out.println("qnaWriteDo test");
    return "question";
  }
  
  



}
