package com.mall.common.provider.response;

import lombok.Data;

@Data
public final class ErrorCode {
    /**
     * 成功
     */
    public static final String SUCCESS = "K-000000";
    /**
     * 失败
     */
    public static final String FAILED= "K-000001";
    /**
     * 参数错误
     */
    public static final String PARAM_ERROR = "K-000009";
}
