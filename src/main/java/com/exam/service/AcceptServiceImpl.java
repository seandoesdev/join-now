package com.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.AcceptDAO;
import com.exam.dto.AcceptDTO;
import com.exam.dto.PageDTO;

@Service
public class AcceptServiceImpl implements AcceptService {
	
	@Autowired
	AcceptDAO dao;
	
	@Override
	public PageDTO selectList(int curPage) {
		return dao.selectList(curPage);
	}

	@Override
	public int acceptAdd(AcceptDTO dto) {
		return dao.acceptAdd(dto);
	}
}
