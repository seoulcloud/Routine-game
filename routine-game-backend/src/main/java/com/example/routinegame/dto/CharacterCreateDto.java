package com.example.routinegame.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CharacterCreateDto {
    private Long userId;
    private Integer level;
    private Integer exp;
    private String stage;
}

