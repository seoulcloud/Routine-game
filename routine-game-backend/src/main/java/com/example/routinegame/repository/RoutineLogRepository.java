package com.example.routinegame.repository;

import com.example.routinegame.entity.RoutineLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineLogRepository extends JpaRepository<RoutineLog, Long> {
}