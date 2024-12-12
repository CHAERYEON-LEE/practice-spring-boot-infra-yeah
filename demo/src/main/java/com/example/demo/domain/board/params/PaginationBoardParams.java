package com.example.demo.domain.board.params;

import com.example.demo.domain.board.dto.GetPaginationBoardListRequest;

public class PaginationBoardParams {
    private int size;
    private int currentPage;

    public PaginationBoardParams(GetPaginationBoardListRequest params){
        this.size = params.getSize();
        this.currentPage = params.getCurrentPage();
    }
}
