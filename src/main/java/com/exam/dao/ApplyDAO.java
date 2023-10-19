package com.exam.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.exam.dto.ApplyDTO;

@Repository
public class ApplyDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	
	public int applyAdd(ApplyDTO dto){
		return session.insert("ApplyMapper.applyAdd", dto);
	}
	
	
}
