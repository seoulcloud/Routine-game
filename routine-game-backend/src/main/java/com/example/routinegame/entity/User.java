package com.example.routinegame.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users") // 테이블 이름은 복수형으로 관례
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
}
