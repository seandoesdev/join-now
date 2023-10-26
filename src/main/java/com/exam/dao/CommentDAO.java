package com.exam.dao;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.exam.dto.ApplyDTO;
import com.exam.dto.CommentDTO;

@Repository
public class CommentDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	
	public int commentAdd(CommentDTO dto){
		return session.insert("CommentMapper.commentAdd", dto);
	}
	
	public List<CommentDTO> commentListbyNo(int postNo){
		return session.selectList("CommentMapper.commentListbyNo",postNo);
	}
	
	
}
