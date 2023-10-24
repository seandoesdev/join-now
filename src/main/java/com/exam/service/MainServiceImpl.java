package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.MainDAO;
import com.exam.dto.PageDTO;
import com.exam.dto.PostDTO;

@Service
public class MainServiceImpl implements MainService {
	
	@Autowired
	MainDAO dao;

	@Override
	public PageDTO selectList(int curPage) {
		return dao.selectList(curPage);
	}

	

}
