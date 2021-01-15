package com.pinnochio.santaclothes.apiserver.service;

import org.springframework.stereotype.Service;

import com.pinnochio.santaclothes.apiserver.service.dto.CaptureEventMessageDto;

@Service
public class EventMessagePublishService {
	public void extract(CaptureEventMessageDto eventDto){
		// Todo consumer extract message 전송
	}

	public void done(CaptureEventMessageDto eventDto){
		// Todo consumer validate?
	}
}
