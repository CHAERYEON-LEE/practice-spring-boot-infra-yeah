package com.example.demo.domain.board.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetPaginationBoardListRequest {
    private int size;
    private int currentPage;

    public int getSize(){
        return this.size;
    }

    public int getCurrentPage(){
        return this.currentPage;
    }
}
