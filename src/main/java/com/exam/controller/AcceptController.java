package com.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AcceptController {

		@GetMapping("/acceptPage")
		public String acceptPage(@RequestParam(value = "curPage", required = false, defaultValue = "1")int curPage,
				Model m) {
			
			return "acceptPage";
		}
}
