package com.example.demo.domain.board;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Builder
public class GetPaginationBoardListRequest {
    @JsonProperty("size")
    private int size;
    @JsonProperty("currentPage")
    private int currentPage;

    public int getSize(){
        return this.size;
    }

    public int getCurrentPage(){
        return this.currentPage;
    }

    public void setPayload(int size, int currentPage) {
        this.size = size;
        this.currentPage = currentPage * size;
    }
}
