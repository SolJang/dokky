package com.study.dokky.api.domain.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.study.dokky.api.domain.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public final class ApiResponse {
    private final int status;
    private final String message;
    private final Object result;

    private ApiResponse(final Status status, final Object data) {
        this.status = status.getCode();
        this.result = data;
        this.message = status.getMessage();
    }

    public static class Builder {
        private Status status;
        private Object result;
        public Builder(){}

        public Builder result(final Object object){
            if(!Objects.isNull(object)) {
                result = object;
            }
            return this;
        }

        public Builder status(final Status status){
            this.status = status;
            return this;
        }

        public ApiResponse build(){
            if(Objects.isNull(status)){
                return new ApiResponse(Status.SUCCESS, result);
            }
            return new ApiResponse(status, result);
        }
    }
}
