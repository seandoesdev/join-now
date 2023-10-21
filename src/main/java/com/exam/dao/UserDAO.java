package com.exam.dao;

import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.securitymodel.User;



@Repository
public class UserDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	//id 중복체크
	public User idCheck(String username) {
		User user = session.selectOne("UserMapper.idCheck", username);
		return user;
		}

}
