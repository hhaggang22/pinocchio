package com.pinnochio.santaclothes.apiserver.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pinnochio.santaclothes.apiserver.dto.CaptureEventCreateRequestResponse;
import com.pinnochio.santaclothes.apiserver.dto.CaptureEventResponse;
import com.pinnochio.santaclothes.apiserver.dto.CaptureEventUpdateRequest;
import com.pinnochio.santaclothes.apiserver.entity.CaptureEvent;
import com.pinnochio.santaclothes.apiserver.service.CaptureService;
import com.pinnochio.santaclothes.apiserver.service.dto.CaptureEventUpdateDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ApiController {
	private final CaptureService captureService;

	@GetMapping("/healthCheck")
	public String healthCheck() {
		return "ok";
	}

	@GetMapping("/capture/event/{eventId}")
	@ResponseStatus(HttpStatus.OK)
	public CaptureEventResponse fetchEvent(@PathVariable("eventId") String eventId) {
		CaptureEvent event = captureService.findById(eventId);
		return CaptureEventResponse.builder()
			.eventId(event.getEventId())
			.imageId(event.getImageId())
			.status(event.getStatus())
			.result(event.getResult())
			.build();
	}

	@PutMapping("/capture/event/{eventId}/resume")
	@ResponseStatus(HttpStatus.OK)
	public void resumeEvent(@PathVariable("eventId") String eventId) {
		captureService.resume(eventId);
	}

	@PostMapping("/capture/event")
	@ResponseStatus(HttpStatus.CREATED)
	public CaptureEventCreateRequestResponse.CaptureEventCreateResponse createEvent(@RequestBody CaptureEventCreateRequestResponse.CaptureEventCreateRequest request) {
		CaptureEvent captureEvent = CaptureEvent.builder()
			.eventId(request.getEventId())
			.imageId(request.getImageId())
			.status(request.getEventStatus())
			.build();
		captureService.save(captureEvent);
		return new CaptureEventCreateRequestResponse.CaptureEventCreateResponse(captureEvent.getEventId());
	}

	@PutMapping("/capture/event")
	@ResponseStatus(HttpStatus.OK)
	public CaptureEventResponse updateEvent(@Valid @RequestBody CaptureEventUpdateRequest request) {
		CaptureEventUpdateDto updateDto = CaptureEventUpdateDto.builder()
			.eventId(request.getEventId())
			.imageId(request.getImageId())
			.status(request.getStatus())
			.build();
		CaptureEvent event = captureService.update(updateDto);

		return CaptureEventResponse.builder()
			.eventId(event.getEventId())
			.imageId(event.getImageId())
			.status(event.getStatus())
			.build();
	}
}
