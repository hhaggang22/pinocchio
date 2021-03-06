package com.pinnochio.santaclothes.apiserver.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pinnochio.santaclothes.apiserver.type.CaptureEventStatus;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CaptureEventResponse {
	String eventId;

	String imageId;

	CaptureEventStatus status;

	// Todo jackson global 설정
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String result;
}

