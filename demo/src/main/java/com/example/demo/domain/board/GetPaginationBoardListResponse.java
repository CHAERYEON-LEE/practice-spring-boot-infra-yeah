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
}
