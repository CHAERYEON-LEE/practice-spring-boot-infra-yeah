package com.example.demo.domain.board.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostBoardItemRequest {
    private String title; // 제목
    private String content; // 내용
    private String tags; // 태그이름

    public String getTitle(){
        return this.title;
    }

    public String getContent(){
        return this.content;
    }

    public String getTags(){
        return this.tags;
    }
}
