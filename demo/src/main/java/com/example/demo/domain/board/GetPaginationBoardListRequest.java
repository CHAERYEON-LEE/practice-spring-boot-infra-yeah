package com.example.demo.domain.board;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetPaginationBoardListRequest {
    private int pageNum;
    private int pageSize;
}
