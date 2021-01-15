package com.pinnochio.santaclothes.apiserver.dto;

import com.pinnochio.santaclothes.apiserver.type.CaptureEventStatus;

import lombok.Builder;
import lombok.Value;

public class CaptureEventCreateRequestResponse {
	@Value
	@Builder
	public static class CaptureEventCreateRequest {
		String eventId;

		String imageId;

		@Builder.Default
		CaptureEventStatus eventStatus = CaptureEventStatus.START;


	}

	@Value
	public static class CaptureEventCreateResponse{
		String eventId;
	}
}
