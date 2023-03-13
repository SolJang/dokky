package com.study.dokky.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum Status {
    SUCCESS(0, "SUCCESS"),
    NOT_FOUND(404, "요청 자원을 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(500, "서버 에러"),
    VALIDATION_ERROR(9999, "서버 에러")


    ;

    private final int code;
    @Getter private final String message;

    public int getCode() {
        return this.code;
    }

    public String getEnumName() {
        return name();
    }

    public Boolean equalsCode(String code) {
        return this.code == Integer.parseInt(code);
    }

}
