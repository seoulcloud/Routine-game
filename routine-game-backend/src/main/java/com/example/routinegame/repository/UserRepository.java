package com.example.routinegame.repository;

import com.example.routinegame.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // 커스텀 메소드 필요 시 여기에 추가
}
