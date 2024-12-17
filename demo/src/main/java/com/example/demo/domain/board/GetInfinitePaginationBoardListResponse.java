package com.example.demo.domain.board;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetInfinitePaginationBoardListResponse {
    private int pageSize;
    private int totalCnt;
    private int hasMore;
    private List<GetBoardListResponse> boardList; // 게시물 목록
}
