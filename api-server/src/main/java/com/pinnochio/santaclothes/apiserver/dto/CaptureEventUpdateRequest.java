package com.pinnochio.santaclothes.apiserver.dto;

import javax.validation.constraints.NotNull;

import com.pinnochio.santaclothes.apiserver.type.CaptureEventStatus;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CaptureEventUpdateRequest {
	@NotNull
	String eventId;

	String imageId;

	@NotNull
	CaptureEventStatus status;
}
