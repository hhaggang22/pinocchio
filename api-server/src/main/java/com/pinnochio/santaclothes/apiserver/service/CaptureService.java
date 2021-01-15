package com.pinnochio.santaclothes.apiserver.service;

import org.springframework.stereotype.Service;

import com.pinnochio.santaclothes.apiserver.entity.CaptureEvent;
import com.pinnochio.santaclothes.apiserver.repository.CaptureEventRepository;
import com.pinnochio.santaclothes.apiserver.service.dto.CaptureEventMessageDto;
import com.pinnochio.santaclothes.apiserver.service.dto.CaptureEventUpdateDto;
import com.pinnochio.santaclothes.apiserver.type.CaptureEventStatus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CaptureService {
	private final CaptureEventRepository captureEventRepository;
	private final EventMessagePublishService messagePublishService;

	public CaptureEvent findById(String eventId) {
		return captureEventRepository.findById(eventId).orElseThrow();
	}

	public void resume(String eventId) {
		CaptureEvent event = findById(eventId);
		CaptureEventStatus status = event.getStatus();
		CaptureEventMessageDto messageDto = CaptureEventMessageDto.builder()
			.eventId(eventId)
			.imageId(event.getImageId())
			.status(event.getStatus())
			.build();

		switch (status) {
			case START:
				// 업로드 완료
				messagePublishService.extract(messageDto);
				break;
			case EXTRACT:
				// 데이터 추출 완료
				messagePublishService.done(messageDto);
				break;
			case DONE:
				// 끝
				break;
		}
	}

	public void save(CaptureEvent event) {
		captureEventRepository.save(event);
	}

	public CaptureEvent update(CaptureEventUpdateDto updateDto) {
		CaptureEvent event = findById(updateDto.getEventId());
		String imageId = updateDto.getImageId();
		if (imageId != null) {
			event.setImageId(imageId);
		}
		event.setStatus(updateDto.getStatus());
		return event;
	}
}

