package com.example.demo.common;

import com.example.demo.domain.board.dto.GetBoardListResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class CommonResponse<T> {
    private int code;
    private String message;
    private T data;

    public CommonResponse(ResponseStatus responseStatus, T data) {
        this.code = responseStatus.code;
        this.message = responseStatus.message;
        this.data = data;
    }
}
