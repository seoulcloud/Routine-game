# Routine-game

루틴 만들기 웹앱 프로젝트



1. 주요 개념 정의

사용자(User): 유저 계정 1개

루틴(Routine): 하루에 하나 이상 수행할 수 있는 목표

루틴 기록(RoutineLog): 오늘 성공/실패 여부 기록

캐릭터(Character): 레벨, 경험치, 진화 단계

성장 로그(LevelLog): 경험치 및 이벤트 히스토리

2. 기본 ERD

User
 ├─ id (PK)
 ├─ username
 ├─ email
 └─ created_at

Routine
 ├─ id (PK)
 ├─ user_id (FK)
 ├─ title (운동, 독서 등)
 ├─ created_at
 └─ is_active

RoutineLog
 ├─ id (PK)
 ├─ routine_id (FK)
 ├─ date
 ├─ status (성공/실패)
 └─ note

Character
 ├─ id (PK)
 ├─ user_id (FK)
 ├─ level
 ├─ exp
 ├─ stage (알, 유아, 청소년 등)
 └─ last_update

LevelLog
 ├─ id (PK)
 ├─ character_id (FK)
 ├─ event (루틴 성공/진화/랜덤뽑기 등)
 ├─ value (얻은 경험치)
 └─ timestamp

 🎁 Item
 ├─ id (PK)
 ├─ name
 ├─ type (모자, 액세서리, 배경 등)
 ├─ rarity (common, rare 등)
 ├─ image_url
 ├─ created_at

🎁 UserItem
 ├─ id (PK)
 ├─ user_id (FK)
 ├─ item_id (FK)
 ├─ is_equipped (착용 여부)
 ├─ acquired_from (예: 랜덤뽑기, 이벤트 등)
 ├─ acquired_at

 🎲 GachaLog
 ├─ id (PK)
 ├─ user_id (FK)
 ├─ item_id (FK)
 ├─ source_event (루틴3성공/3실패 등)
 ├─ result_rarity
 ├─ created_at

😺 CharacterEmotion
 ├─ id (PK)
 ├─ character_id (FK)
 ├─ emotion (애교/툴툴댐/기쁨/졸림 등)
 ├─ trigger (예: 루틴 실패 3일 연속)
 ├─ created_at

| 조건                | 행동                   |
| -----------        | ---------------        |
| 루틴 성공 1회        | 경험치 +10              |
| 루틴 3개 이상 성공   | 랜덤뽑기 + 1 캐릭터가 애교  |
| 루틴 실패 3일 연속   | 랜덤뽑기 + 1 캐릭터가 툴툴댐|
| 경험치 100 단위     | 진화                     |
