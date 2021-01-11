package com.pinocchio.santaclothes.imageserver.dto;

import java.time.Instant;

import org.springframework.web.multipart.MultipartFile;

import lombok.Value;

@Value
public class ImageUploadResponseDto {
	String userId;

	Instant uploadDateTime;

	MultipartFile uploadFile;
}
