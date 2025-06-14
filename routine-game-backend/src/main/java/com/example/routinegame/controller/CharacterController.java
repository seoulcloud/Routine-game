package com.example.routinegame.controller;

import java.sql.Timestamp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.routinegame.entity.CharacterCreateDto;
import com.example.routinegame.repository.CharacterRepository;
import com.example.routinegame.service.CharacterService;
import com.example.routinegame.entity.Character;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@RestController
@RequestMapping("/api/character")
@RequiredArgsConstructor
@Getter @Setter
public class CharacterController {

    private final CharacterService characterService;
    private final CharacterRepository characterRepository;

    @PostMapping("/{userId}/result")
    public void applyRoutineResult(@PathVariable Long userId, @RequestParam boolean isSuccess) {
        characterService.applyRoutineResult(userId, isSuccess);
    }
        
    @PostMapping("/create")
    public ResponseEntity<?> createCharacter(@RequestBody CharacterCreateDto dto) {
    	Character character = new Character();
        character.setUserId(dto.getUserId());
        character.setLevel(dto.getLevel());
        character.setExp(dto.getExp());
        character.setStage(dto.getStage());
        character.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        characterRepository.save(character);
        return ResponseEntity.ok("캐릭터 생성 완료");
        
    }
}
