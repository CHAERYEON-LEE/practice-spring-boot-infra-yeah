package com.example.demo.domain.board.dto;

import com.example.demo.domain.board.Board;
import com.example.demo.domain.board.PaginationInfo;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostBoardItemUpdateRequest {
    private long board_id; // 게시물 id
    private String title; // 제목
    private String content; // 내용
    private String tags; // 태그이름

    public long getBoardId(){ return this.board_id; }

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
