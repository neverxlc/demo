package com.example.demo.exception;

import com.example.demo.spi.ErrorCode;

/**
 *
 */
public enum CommonErrorCode implements ErrorCode {

    SYSTEM_ERROR("10001", "系统错误"),
    ;



    private final String code;

    private final String description;

    CommonErrorCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getDescription() {
        return this.description;
    }


    @Override
    public String toString() {
        return String.format("Code:[%s], Description:[%s]", this.code, this.description);
    }
}
