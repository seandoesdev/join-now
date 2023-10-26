package com.exam.service;

import java.util.List;

import com.exam.dto.CommentDTO;

public interface CommentService {

	public int commentAdd(CommentDTO dto);
	public List<CommentDTO> commentListbyNo(int postNo);
	
}
