package com.pinnochio.santaclothes.apiserver.service.dto;

import com.pinnochio.santaclothes.apiserver.type.CaptureEventStatus;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CaptureEventMessageDto {
	String eventId;

	String imageId;

	CaptureEventStatus status;
}
