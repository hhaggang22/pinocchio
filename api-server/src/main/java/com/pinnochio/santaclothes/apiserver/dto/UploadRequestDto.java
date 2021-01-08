package com.pinnochio.santaclothes.apiserver.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UploadRequestDto {

	String userId;

	public String getUserId() {

		return userId;
	}
}
