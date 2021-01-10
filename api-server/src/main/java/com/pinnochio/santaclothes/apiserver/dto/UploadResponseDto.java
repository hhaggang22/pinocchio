package com.pinnochio.santaclothes.apiserver.dto;

import java.time.Instant;
import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Value;

@Value
public class UploadResponseDto {
	String userId;

	Instant uploadDateTime;

	MultipartFile uploadFile;
}
