package com.pinnochio.santaclothes.apiserver.dto;

import java.time.Instant;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
public class UploadRequestDto {

	String userId;
	Instant uploadDateTime;

	public String getUserId() {
		return userId;
	}

	public Instant getUploadDateTime() {
		return uploadDateTime;
	}



}
