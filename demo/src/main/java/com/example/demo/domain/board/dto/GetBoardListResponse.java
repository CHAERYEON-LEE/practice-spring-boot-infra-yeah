package com.example.demo.domain.board.dto;

import com.example.demo.domain.board.vo.BoardVo;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetBoardListResponse {
    private long board_id; // 게시물 id
    private String title; // 제목
    private String content; // 내용
    private long views; // 조회수
    private String tags; // 태그이름
    private LocalDateTime created_at; // 작성일자
    private LocalDateTime updated_at; // 수정일자
    private String delete_yn; // 삭제여부 Y, N

    public GetBoardListResponse(BoardVo vo) {
        this.board_id = vo.getBoardId();
        this.title = vo.getTitle();
        this.content = vo.getContent();
        this.views = vo.getViews();
        this.tags = vo.getTags();
        this.created_at = vo.getCreated_at();
        this.updated_at = vo.getUpdated_at();
        this.delete_yn = vo.getDelete_yn();
    }
}
