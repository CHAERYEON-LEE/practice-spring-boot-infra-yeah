package com.example.demo.domain.board.dto;

import com.example.demo.domain.board.Board;
import com.example.demo.domain.board.PaginationInfo;

import java.util.List;

public class GetPaginationBoardListResponse {
    private List<Board> boardList;
    private PaginationInfo paginationInfo;

    public GetPaginationBoardListResponse(List<Board> boardList, PaginationInfo paginationInfo){
        this.boardList = boardList;
        this.paginationInfo = paginationInfo;
    }
}
