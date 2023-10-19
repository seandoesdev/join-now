package com.exam.controller;

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

import com.exam.dto.PageDTO;
import com.exam.dto.PostDTO;
import com.exam.service.MainServiceImpl;


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
		m.addAttribute("pageDTO", service.selectList(curPage));	
		return "main";
	}
	
}
