package com.exam.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exam.dto.PositionDTO;
import com.exam.dto.PostDTO;

@Repository
public class PositionDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	public List<PositionDTO> positionList(int postNo){
		return session.selectList("PositionMapper.positionList",postNo);
	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public int positionAdd(int postNo, PostDTO dto, PositionDTO dto2) {
	    //번호 자동 생성
	    String postSql = "INSERT INTO post (studyType, title, onoff, region, content, contact, deadline, startDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    jdbcTemplate.update(postSql, dto.getStudyType(), dto.getTitle(), dto.getOnoff(), dto.getRegion(), dto.getContent(), dto.getContact(), dto.getDeadline(), dto.getStartDate());

	    //postNo 값 삽입
	    String retrievePostNoSql = "SELECT LAST_INSERT_ID()";
	    postNo = jdbcTemplate.queryForObject(retrievePostNoSql, Integer.class);

	    //구분자로 나눠줌
	    String[] categorySplit = dto2.getCategory().split(",");
	    String[] recruitTypeSplit = dto2.getRecruitType().split(",");
	    String[] memberSizeSplit = dto2.getMemberSize().split(",");

	    int totalInserts = 0;

	    //단어 길이
	    int numValues = Math.min(categorySplit.length, Math.min(recruitTypeSplit.length, memberSizeSplit.length));

	    for (int i = 0; i < numValues; i++) {
	        
	        PositionDTO position = new PositionDTO();
	        position.setPostNo(postNo); //같은 postNo 번호로 삽입
	        position.setCategory(categorySplit[i]);
	        position.setRecruitType(recruitTypeSplit[i]);
	        position.setMemberSize(memberSizeSplit[i]);

	        //positionDTO에 삽입
	        String positionSql = "INSERT INTO position (postNo, category, recruitType, memberSize) VALUES (?, ?, ?, ?)";
	        jdbcTemplate.update(positionSql, position.getPostNo(), position.getCategory(), position.getRecruitType(), position.getMemberSize());
	        totalInserts++;
	    }

	    return totalInserts;
	}
	
	
	public int positionUpdate(PositionDTO dto){
		return session.update("PositionMapper.positionUpdate", dto);
	}
	
	public int positionDelete(int postNo) {
		return session.update("PositionMapper.positionDelete", postNo);
	}
	
}
