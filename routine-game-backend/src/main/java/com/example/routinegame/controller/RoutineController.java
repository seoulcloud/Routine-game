package com.example.routinegame.controller;

import com.example.routinegame.entity.*;
import com.example.routinegame.repository.*;
import com.example.routinegame.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/api/routine")
@RequiredArgsConstructor
public class RoutineController {

    private final RoutineRepository routineRepository;
    private final RoutineLogRepository routineLogRepository;
    private final UserRepository userRepository;
    private final CharacterService characterService;

    @PostMapping("/create")
    public ResponseEntity<?> createRoutine(@RequestParam Long userId, @RequestParam String title, @RequestParam String description) {
        User user = userRepository.findById(userId).orElseThrow();

        Routine routine = Routine.builder()
                .user(user)
                .title(title)
                .description(description)
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .build();

        routineRepository.save(routine);
        return ResponseEntity.ok("루틴 생성 완료");
    }

    @PostMapping("/log")
    public ResponseEntity<?> logRoutine(@RequestParam Long routineId, @RequestParam boolean isSuccess, @RequestParam(required = false) String note) {
        Routine routine = routineRepository.findById(routineId).orElseThrow();

        RoutineLog log = RoutineLog.builder()
                .routine(routine)
                .performedAt(new Timestamp(System.currentTimeMillis()))
                .isSuccess(isSuccess)
                .note(note)
                .build();

        routineLogRepository.save(log);

        // 캐릭터 경험치 반영
        characterService.applyRoutineResult(routine.getUser().getId(), isSuccess);

        return ResponseEntity.ok("루틴 수행 결과 저장 완료");
    }
}