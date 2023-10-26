package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.CommentDAO;
import com.exam.dto.CommentDTO;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDAO dao;
	
	@Override
	public int commentAdd(CommentDTO dto) {
		return dao.commentAdd(dto);
	}

	@Override
	public List<CommentDTO> commentListbyNo(int postNo) {
		return dao.commentListbyNo(postNo);
	}

}