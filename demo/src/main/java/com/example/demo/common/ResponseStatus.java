package com.example.demo.common;

import lombok.Getter;

public enum ResponseStatus {
    SUCCESS(200, "요청이 성공했습니다"),
    BAD_REQUEST(400, "잘못된 요청입니다."),
    NOT_FOUND(404, "리소스를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(500, "서버에 오류가 발생했습니다.");

    @Getter
    public final int code;
    public final String message;

    ResponseStatus(int code, String message){
        this.code = code;
        this.message = message;
    }
}
