package com.mall.common.provider.Exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class SbcException extends RuntimeException{

    private String code;

    public SbcException(String msg) {
        super(msg);
        this.code = "K-000001";
    }

    public SbcException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
