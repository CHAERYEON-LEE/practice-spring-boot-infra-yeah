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
    private int pageNum;
    private int pageSize;
    private int totalCnt;
    private List<GetBoardListResponse> boardList; // 게시물 목록

    public void setBoardList(List<GetBoardListResponse> boardList) {
        this.boardList = boardList;
    }

    public void setPaginationInfo (int pageNum, int pageSize, int totalCnt) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalCnt = totalCnt;
    }
}
