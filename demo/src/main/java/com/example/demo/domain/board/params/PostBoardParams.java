package com.example.demo.domain.board.params;

import com.example.demo.domain.board.dto.PostBoardItemRequest;

import java.time.LocalDateTime;

public class PostBoardParams {
    private String title; // 제목
    private String content; // 내용
    private String tags; // 태그이름

    public PostBoardParams(PostBoardItemRequest params){
        this.title = params.getTitle();
        this.content = params.getContent();
        this.tags = params.getTags();
    }
}
