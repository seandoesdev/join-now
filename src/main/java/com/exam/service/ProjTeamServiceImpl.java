package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.exam.dao.ProjTeamDAO;
import com.exam.dto.ProjDTO;
import com.exam.dto.QuestionDTO;
import com.exam.dto.ScheduleDTO;
import com.exam.dto.TestDTO;

@Service
public class ProjTeamServiceImpl implements ProjTeamService {

  @Autowired
  ProjTeamDAO dao;
  
  
  /**
   * 일정표
   */
  @Override
  public int insertEvent(List<ScheduleDTO> scheduleDTO) {
    return dao.insertEvent(scheduleDTO);
  }
  
  @Override
  public List<ScheduleDTO> selectAllEventbyId() {
    return dao.selectAllEventbyId();
  }


  
  @Override
  public ProjDTO selectAllbyId() {
    
    return dao.selectAllbyId();
  }

 



}
