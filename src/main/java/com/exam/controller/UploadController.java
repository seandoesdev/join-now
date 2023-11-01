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
		
		// 폴더 생성
		String folderPath = "C:\\upload";
        File folder = new File(folderPath);

        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            if (created) {
                System.out.println("폴더가 생성되었습니다.");
            } else {
                System.out.println("폴더 생성에 실패했습니다.");
            }
        } else {
            System.out.println("이미 폴더가 존재합니다.");
        }
			
		
		// 로컬 파일 저장
		File f = new File("c:\\upload", originalFilename);
		
		try {
			theFile.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		// 클라우드에 저장
		storageService.upload(originalFilename, "c:\\upload\\"+originalFilename);
		
		// 파일 삭제
		String filePath = "c:\\upload\\"+originalFilename;
        File file = new File(filePath);

        if (file.exists()) {
            boolean deleted = file.delete();
            if (deleted) {
                System.out.println("파일이 삭제되었습니다.");
            } else {
                System.out.println("파일 삭제에 실패했습니다.");
            }
        } else {
            System.out.println("파일이 존재하지 않습니다.");
        }
		
		return "uploadForm";
	}
}
