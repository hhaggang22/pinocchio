package com.pinocchio.santaclothes.imageserver.controller;

import java.io.File;
import java.io.IOException;
import java.time.Instant;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pinocchio.santaclothes.imageserver.dto.ImageUploadRequestDto;
import com.pinocchio.santaclothes.imageserver.dto.ImageUploadResponseDto;

@RestController
public class ImageController {
	@PostMapping("/Imageupload")
	public ImageUploadResponseDto upload(@ModelAttribute ImageUploadRequestDto requestDto) { // 요청받은 데이터를 UploadRequestDto에 저장
		String userId = requestDto.getUserId();
		Instant uploadDateTime = requestDto.getUploadDateTime();
		MultipartFile uploadFile = requestDto.getUploadFile();

		String originalFileName = uploadFile.getOriginalFilename();
		File dest = new File("C:/Image/" + originalFileName);
		try{
			uploadFile.transferTo(dest);
		}catch(IOException e){
			e.printStackTrace();
		}

		return new ImageUploadResponseDto(userId, uploadDateTime, uploadFile);
	}
}
