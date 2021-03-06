package com.pinocchio.santaclothes.imageserver.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pinocchio.santaclothes.imageserver.entity.CaptureImage;
import com.pinocchio.santaclothes.imageserver.repository.CaptureImageRepository;
import com.pinocchio.santaclothes.imageserver.service.dto.CaptureImageRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class CaptureEventService {
	private static final String FILE_PREFIX_URL = "/image";
	private final Sinks.Many<CaptureEventCreateMessage> captureCreateEmitter;
	private final Sinks.Many<CaptureEventProcessRequestMessage> captureProcessRequestEmitter;
	private final CaptureImageRepository captureImageRepository;

	public CaptureEventService(
		@Qualifier("captureCreateEmitter") Sinks.Many<CaptureEventCreateMessage> captureCreateEmitter,
		@Qualifier("captureProcessRequestEmitter") Sinks.Many<CaptureEventProcessRequestMessage> captureProcessRequestEmitter,
		CaptureImageRepository captureImageRepository
	) {
		this.captureCreateEmitter = captureCreateEmitter;
		this.captureProcessRequestEmitter = captureProcessRequestEmitter;
		this.captureImageRepository = captureImageRepository;
	}

	public void saveImage(CaptureImageRequest request) {
		MultipartFile file = request.getImage();
		String originalFileName = file.getOriginalFilename();
		String fileName = UUID.randomUUID().toString();
		String filePath = FILE_PREFIX_URL + fileName;
		CaptureImage captureImage = CaptureImage.builder()
			.imageId(request.getImageId())
			.originalFileName(originalFileName)
			.savedFileName(fileName)
			.filePath(filePath)
			.build();
		captureImageRepository.save(captureImage);
		captureCreateEmitter.tryEmitNext(new CaptureEventCreateMessage(request.getEventId(), request.getImageId()));
		captureProcessRequestEmitter.tryEmitNext(
			new CaptureEventProcessRequestMessage(request.getEventId(), request.getImageId())
		);
	}
}
