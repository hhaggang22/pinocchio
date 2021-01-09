package com.pinnochio.santaclothes.apiserver.dto;

import java.time.Instant;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UploadRequestDto {

	String userId;

	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Instant uploadDateTime = Instant.now();

	MultipartFile uploadFile;


}
