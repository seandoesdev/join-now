package com.exam.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.dto.NotificationDTO;
import com.exam.dto.PageDTO;
import com.exam.dto.PostDTO;
import com.exam.dto.UserInfoDTO;
import com.exam.navercloud.openapi.service.ObjectStorageService;
import com.exam.service.MainServiceImpl;
import com.exam.service.NotificationService;


@Controller
public class MainContoller {
		
	/*
		기존 SpringFramework의  application scope 사용
		   1) implements ServletContextAware
		   2) @Override
		   
		public void setServletContext(ServletContext servletContext) {
			this.application = servletContext;
		}
	*/
	
	@Autowired
	MainServiceImpl service;
		

	
	@GetMapping("/main")
	public String main(@RequestParam(value = "curPage", required = false, defaultValue = "1")int curPage,
						Model m) {
		
		PageDTO pageDTO = service.selectList(curPage);
		
		pageDTO.setList(mergeSort(pageDTO.getList()));
		
		m.addAttribute("pageDTO", pageDTO);
			
				
		return "main";
	}
	
	// 병합 정렬 알고리즘 (조회수로 정렬)
    public static List<PostDTO> mergeSort(List<PostDTO> list) {
        if (list.size() <= 1) return list; // 리스트가 비어있거나 이미 정렬되어 있으면 종료

        int mid = list.size() / 2;
        List<PostDTO> left = new ArrayList<>(list.subList(0, mid));
        List<PostDTO> right = new ArrayList<>(list.subList(mid, list.size()));

        left = mergeSort(left); // 왼쪽 부분을 재귀적으로 정렬
        right = mergeSort(right); // 오른쪽 부분을 재귀적으로 정렬

        return merge(left, right); // 정렬된 부분을 병합
    }

    public static List<PostDTO> merge(List<PostDTO> left, List<PostDTO> right) {
        List<PostDTO> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
        	// 값을 비교 하는 부분
            if (left.get(i).getViewCount() >= right.get(j).getViewCount()) { // 값 비교
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }

        while (i < left.size()) {
            merged.add(left.get(i++));
        }

        while (j < right.size()) {
            merged.add(right.get(j++));
        }

        return merged;
    }
	
}
