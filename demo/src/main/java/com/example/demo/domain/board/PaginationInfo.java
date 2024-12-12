package com.example.demo.domain.board;

import java.util.List;

public class PaginationInfo {
    private int pageSize; // 한 페이지에서 보여줄 아이템 개수
    private int currentPageNo; // 현재 요청 페이지 번호
    private int totalCount; // 총 아이템 개수

    public PaginationInfo(int pageSize, int currentPageNo, int totalCount){
        this.pageSize = pageSize;
        this.currentPageNo = currentPageNo;
        this.totalCount = totalCount;
    }
}
