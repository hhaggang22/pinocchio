package com.pinnochio.santaclothes.apiserver.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UploadRequestDto {

	String userId;

	@JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
	LocalDateTime uploadDateTime;

	public String getUserId() {
		return userId;
	}

	public LocalDateTime getUploadDateTime() {
		return uploadDateTime;
	}
}
