package com.exam.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exam.dto.ApplyDTO;
import com.exam.dto.PositionDTO;
import com.exam.dto.SkillDTO;

@Repository
public class SkillDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public int skillAdd(ApplyDTO dto, List<SkillDTO> list){
		//번호 자동 생성
	    String applySql = "INSERT INTO apply (applyType, content, userid, contact, postNo) VALUES (?, ?, ?, ?, ?)";
	    jdbcTemplate.update(applySql,dto.getApplyType(),dto.getContent(),dto.getUserid(),dto.getContact(),dto.getPostNo());

	    //applyNo 값 삽입
	    String applyNoSql = "SELECT LAST_INSERT_ID()";
	    int applyNo = jdbcTemplate.queryForObject(applyNoSql, Integer.class);
	    int totalInserts = 0;
	    for (SkillDTO sk:list) {
	    	
	        //SkillDTO에 삽입
	        String skillSql = "INSERT INTO skill (applyNo, skill) VALUES (?, ?)";
	        jdbcTemplate.update(skillSql, applyNo, sk.getSkill());
	        totalInserts++;
	    }
	    return applyNo;
	}
	
	public List<SkillDTO> skillList(int applyNo) {
		return session.selectList("SkillMapper.skillList",applyNo);
	}
	
}
