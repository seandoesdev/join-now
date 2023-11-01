package com.exam.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;


import com.exam.dto.UploadDTO;
import com.exam.navercloud.openapi.service.ObjectStorageService;

@Controller
public class UploadController {
	
	@Autowired
	ObjectStorageService storageService;
	
	@GetMapping("/uploadForm")
	public String uploadForm() {
		return "uploadForm"; // /WEB-INF/views/uploadForm.jsp
	}
	
	@PostMapping("/upload")
	public String upload(UploadDTO dto) {
		 
		String theText = dto.getTheText();
		MultipartFile theFile = dto.getTheFile();
		
		// 파일 정보
		long size = theFile.getSize();
		String name = theFile.getName();
		String originalFilename = theFile.getOriginalFilename();
		String contentType = theFile.getContentType();
		
		System.out.println(size);
		System.out.println(name);
		System.out.println(originalFilename);
		System.out.println(contentType);
		
		File f = new File("c:\\upload", originalFilename);
		
		try {
			theFile.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		storageService.upload(originalFilename, "c:\\upload\\"+originalFilename);
		
		return "uploadForm";
	}
}
