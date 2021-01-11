package com.pinocchio.santaclothes.imageserver.dto;

import java.time.Instant;

import org.springframework.web.multipart.MultipartFile;

public class ImageUploadResponseDto {
	String userId;

	Instant uploadDateTime;

	MultipartFile uploadFile;
}
