package com.mall.common.provider.Exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class SbcException extends Throwable{

    public SbcException(String msg) {
        super(msg);
    }

    public SbcException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
