package com.exam.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.dto.PageDTO;
import com.exam.dto.PostDTO;

@Repository
public class MainDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	public int totalCount() {
		return session.selectOne("MainMapper.totalCount");
	}
	
	public int totalCountTitle() {
		return session.selectOne("MainMapper.totalCountTitle");
	}
	
	public PageDTO selectList(int curPage){
		PageDTO pageDTO = new PageDTO();
		// pageDTO.setPerPage(11); => 한 페이지의 리스트 개수를 11개로 설정
		// RowBounds(offset, limit) 한 페이지에 나오는 리스트 개수 만큼, List<PostDTO> list에 담는다. 
		int offset = (curPage-1)*pageDTO.getPerPage();
		int limit = pageDTO.getPerPage();
		List<PostDTO> list =  session.selectList("MainMapper.selectList", null, new RowBounds(offset, limit));
		
		pageDTO.setList(list);
		pageDTO.setCurPage(curPage);
		pageDTO.setTotalCount(totalCount());
		
		// 페이지 개수 조정 -> 설정을 안하고 설계를 하면 리스트가 6개일 경우 페이지가 1장만 있으면 모두 출력 가능하지만 2장이 출력되게끔 밖에 설계가 불가능함.
		// 그래서 if문을 사용하여 페이징을 처리 함.
		if(totalCount()%pageDTO.getPerPage()==0) {
			pageDTO.setPageNum(totalCount()/pageDTO.getPerPage());
		}else {
			pageDTO.setPageNum(totalCount()/pageDTO.getPerPage()+1);
		}
		
		if(totalCount()==0) {
			pageDTO.setPageNum(1);
		}
		
		return pageDTO;
	}
	
	public PageDTO searchTitle(int curPage, String keyword) {
		PageDTO pageDTO = new PageDTO();
		// pageDTO.setPerPage(11); => 한 페이지의 리스트 개수를 11개로 설정
		// RowBounds(offset, limit) 한 페이지에 나오는 리스트 개수 만큼, List<PostDTO> list에 담는다. 
		int offset = (curPage-1)*pageDTO.getPerPage();
		int limit = pageDTO.getPerPage();
		List<PostDTO> list =  session.selectList("MainMapper.searchTitle", keyword, new RowBounds(offset, limit));
		
		pageDTO.setList(list);
		pageDTO.setCurPage(curPage);
		pageDTO.setTotalCount(totalCountTitle());
		
		// 페이지 개수 조정 -> 설정을 안하고 설계를 하면 리스트가 6개일 경우 페이지가 1장만 있으면 모두 출력 가능하지만 2장이 출력되게끔 밖에 설계가 불가능함.
		// 그래서 if문을 사용하여 페이징을 처리 함.
		if(totalCountTitle()%pageDTO.getPerPage()==0) {
			pageDTO.setPageNum(totalCountTitle()/pageDTO.getPerPage());
		}else {
			pageDTO.setPageNum(totalCountTitle()/pageDTO.getPerPage()+1);
		}
		
		if(totalCountTitle()==0) {
			pageDTO.setPageNum(1);
		}
		
		return pageDTO;
	}
}
