package com.example.demo.domain.board.params;

import com.example.demo.domain.board.dto.PostBoardItemUpdateRequest;

public class UpdateBoardParams {
    private long board_id; // 게시물 id
    private String title; // 제목
    private String content; // 내용
    private String tags; // 태그

    public UpdateBoardParams(PostBoardItemUpdateRequest params){
        this.board_id = params.getBoardId();
        this.title = params.getTitle();
        this.content = params.getContent();
        this.tags = params.getTags();
    }
}
