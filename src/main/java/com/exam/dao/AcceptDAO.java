package com.exam.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.dto.AcceptDTO;
import com.exam.dto.PageDTO;
import com.exam.dto.PostDTO;

@Repository
public class AcceptDAO {
	@Autowired
	SqlSessionTemplate session;
	
	public List<AcceptDTO> selectListApplyUser(int userid){
		return session.selectList("AcceptMapper.selectListApplyUser", userid);
	}
	
	public int acceptAdd(AcceptDTO dto) {
		return session.insert("AcceptMapper.acceptAdd", dto);
	}
}
