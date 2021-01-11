package com.pinocchio.santaclothes.imageserver.dto;

import java.time.Instant;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ImageUploadRequestDto {
	String userId;

	Instant uploadDateTime = Instant.now();

	MultipartFile uploadFile;
}
