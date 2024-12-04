package com.example.demo.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    private  long id; // 게시물 id
    private String title; // 제목
    private String content; // 내용
    private String writer; // 작성자
    private long views; // 조회수
    private LocalDateTime createdAt; // 작성일자
    private LocalDateTime updatedAt; // 수정일자
}
