package com.pinnochio.santaclothes.apiserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinnochio.santaclothes.apiserver.entity.CaptureEvent;

public interface CaptureEventRepository extends JpaRepository<CaptureEvent, String> {
}
