package com.example.routinegame.service;

import com.example.routinegame.entity.Character;
import com.example.routinegame.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterService {
    private final CharacterRepository characterRepository;

    public void applyRoutineResult(Long userId, boolean isSuccess) {
        Character character = characterRepository.findByUserId(userId)
            .orElseThrow(() -> new RuntimeException("캐릭터 없음"));

        if (isSuccess) {
            int updatedExp = character.getExp() + 10;
            character.setExp(updatedExp);

            if (updatedExp >= 100) {
                character.setLevel(character.getLevel() + 1);
                character.setExp(updatedExp % 100);
                character.setStage(getNextStage(character.getStage()));
            }
            characterRepository.save(character);
        }
    }

    private String getNextStage(String stage) {
        return switch (stage) {
            case "알" -> "유년기";
            case "유년기" -> "성장기";
            case "성장기" -> "성숙기";
            case "성숙기" -> "완전체";
            default -> stage;
        };
    }
}
