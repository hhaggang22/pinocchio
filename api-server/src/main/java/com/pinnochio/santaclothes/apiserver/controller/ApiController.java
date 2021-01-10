package com.pinnochio.santaclothes.apiserver.controller;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;

import javax.persistence.criteria.CriteriaBuilder;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pinnochio.santaclothes.apiserver.dto.UploadRequestDto;
import com.pinnochio.santaclothes.apiserver.dto.UploadResponseDto;

@RestController
public class ApiController {

	@PostMapping("/upload")
	public UploadResponseDto upload(@ModelAttribute UploadRequestDto requestDto) { // 요청받은 데이터를 UploadRequestDto에 저장
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

		return new UploadResponseDto(userId, uploadDateTime, uploadFile);
	}

}
