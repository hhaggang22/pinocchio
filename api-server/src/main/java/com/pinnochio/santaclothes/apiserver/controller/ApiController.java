package com.pinnochio.santaclothes.apiserver.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pinnochio.santaclothes.apiserver.dto.UploadRequestDto;
import com.pinnochio.santaclothes.apiserver.dto.UploadResponseDto;

@RestController
public class ApiController {

	@PostMapping("/upload")
	public UploadResponseDto upload(@RequestBody UploadRequestDto requestDto) { // 요청받은 데이터를 UploadRequestDto에 저장
		String userId = requestDto.getUserId();
		LocalDateTime uploadDateTime = requestDto.getUploadDateTime();

		return new UploadResponseDto(userId, uploadDateTime);
	}

}
