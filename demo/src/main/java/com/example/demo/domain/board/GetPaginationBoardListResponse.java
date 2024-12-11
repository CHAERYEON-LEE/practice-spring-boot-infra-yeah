package com.example.demo.domain.board;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetPaginationBoardListResponse {
    private PaginationInfo paginationInfo; // 페이지네이션 정보
    private List<Board> boardList; // 게시물 목록

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Board {
        private long board_id; // 게시물 id
        private String title; // 제목
        private String content; // 내용
        private long views; // 조회수
        private String tags; // 태그이름
        private LocalDateTime created_at; // 작성일자
        private LocalDateTime updated_at; // 수정일자
        private String delete_yn; // 삭제여부 Y, N
    }

    public void setBoardList(List<Board> boardList) {
        this.boardList = boardList;
    }
}
