package com.example.demo.domain.board.vo;

import java.time.LocalDateTime;

public class BoardVo {
    private long board_id; // 게시물 id
    private String title; // 제목
    private String content; // 내용
    private long views; // 조회수
    private String tags; // 태그이름
    private LocalDateTime created_at; // 작성일자
    private LocalDateTime updated_at; // 수정일자
    private String delete_yn; // 삭제여부 Y, N

    public long getBoardId() {
        return board_id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public long getViews() {
        return views;
    }

    public String getTags() {
        return tags;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public String getDelete_yn() {
        return delete_yn;
    }
}
