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
    private int size; // 한 페이지에서 보여줄 아이템 개수
    private int currentPage; // 현재 요청 페이지
    private int totalCount; // 아이템 총 개수
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

    public void setPaginationData(int size, int currentPage, int totalCount){
        this.size = size;
        this.currentPage = currentPage;
        this.totalCount = totalCount;
    }

    public void setBoardList(List<Board> boardList) {
        this.boardList = boardList;
    }
}
