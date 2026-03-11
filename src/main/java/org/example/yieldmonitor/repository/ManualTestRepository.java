package org.example.yieldmonitor.repository;

import org.example.yieldmonitor.model.ManualTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManualTestRepository extends JpaRepository<ManualTest, Long> {
}