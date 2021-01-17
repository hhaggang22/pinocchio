package com.pinocchio.santaclothes.imageserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaptureImageRepository extends JpaRepository<CaptureImage, String> {
}
