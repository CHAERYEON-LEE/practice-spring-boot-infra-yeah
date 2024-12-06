package com.example.demo.domain.board;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    private long board_id; // 게시물 id
    private String title; // 제목
    private String content; // 내용
    private long views; // 조회수
    private String tags; // 태그이름
    private LocalDateTime created_at; // 작성일자
    private LocalDateTime updated_at; // 수정일자
    private String delete_yn; // 삭제여부 Y, N
}
