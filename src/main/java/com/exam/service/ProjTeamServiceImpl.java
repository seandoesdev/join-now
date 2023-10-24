package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.ProjTeamDAO;
import com.exam.dto.ProjDTO;
import com.exam.dto.QuestionDTO;
import com.exam.dto.ScheduleDTO;
import com.exam.dto.TestDTO;

@Service
public class ProjTeamServiceImpl implements ProjTeamService {

  @Autowired
  ProjTeamDAO dao;

  @Override
  public List<ScheduleDTO> insertSch() {
    return dao.insertSch();
  }

  @Override
  public List<TestDTO> testSelect() {
    return dao.testSelect();
  }

  @Override
  public ProjDTO selectAllbyId() {
    
    return dao.selectAllbyId();
  }

  @Override
  public int createPost(QuestionDTO questionDTO) {
    return dao.createPost(questionDTO);
  }



}
