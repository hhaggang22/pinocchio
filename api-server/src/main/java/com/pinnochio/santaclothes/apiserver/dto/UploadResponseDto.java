package com.pinnochio.santaclothes.apiserver.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Value;

@Value
public class UploadResponseDto {
	String userId;

	@JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
	LocalDateTime uploadDateTime;

	public UploadResponseDto(String userId, LocalDateTime uploadDateTime) {
		this.userId = userId;
		this.uploadDateTime = uploadDateTime;
	}
}
