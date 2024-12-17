package com.example.demo.domain.board;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetInfinitePaginationBoardListRequest {
    private Long lastBoardId;
    private int pageSize;
}
