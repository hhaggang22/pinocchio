package com.pinnochio.santaclothes.apiserver.dto;

import java.time.Instant;
import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UploadRequestDto {

	String userId;

	Instant uploadDateTime = Instant.now();

	MultipartFile uploadFile;
}
