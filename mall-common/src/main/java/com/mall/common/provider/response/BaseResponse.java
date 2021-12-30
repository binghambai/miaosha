package com.mall.common.provider.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponse<T> implements Serializable {
    private String code;

    private String msg;

    private T context;

    public BaseResponse(String code) {
        this.code = code;
    }

    public static BaseResponse SUCCESSFUL() {
        return new BaseResponse(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMsg(), null );
    }

    public static BaseResponse FAILED() {
        return new BaseResponse(ErrorCode.FAILED.getCode());
    }

    public static <T> BaseResponse<T> success(T context) {
        return new BaseResponse<>(ErrorCode.SUCCESS.getCode(), null, context);
    }

    public static BaseResponse error(String code, String msg) {
        return new BaseResponse<>(code, msg, null);
    }

    public static BaseResponse info(String code, String msg) {
        return new BaseResponse<>(code, msg, null);
    }
 }
