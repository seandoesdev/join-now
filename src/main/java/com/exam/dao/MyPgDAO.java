package com.exam.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.dto.MyPgDTO;
import com.exam.dto.TestDTO;

@Repository
public class MyPgDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	public MyPgDTO selectList(){
		MyPgDTO mypgDTO = new MyPgDTO();
		List<MyPgDTO> list = session.selectList("MyPageMapper.selectList", mypgDTO);
	//	mypgDTO.setList(list); //이것도 안 됨 진짜 눈물나네
		return mypgDTO;
	}
	
	
	public int update(MyPgDTO dto) {
		return session.update("MyPageMapper.update", dto);
	}
	
	
}
