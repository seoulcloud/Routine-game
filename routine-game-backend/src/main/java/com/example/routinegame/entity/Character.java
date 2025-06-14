package com.example.routinegame.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "characters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Integer level = 1;
    private Integer exp = 0;
    private String stage = "알";
    
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
}
