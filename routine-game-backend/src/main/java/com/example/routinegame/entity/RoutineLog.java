package com.example.routinegame.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;

@Entity
@Table(name = "routine_logs")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class RoutineLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routine_id")
    private Routine routine;

    @Column(name = "performed_at")
    private Timestamp performedAt;

    @Column(name = "is_success")
    private Boolean isSuccess;

    private String note;
}