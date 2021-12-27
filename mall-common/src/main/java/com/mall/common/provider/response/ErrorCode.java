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
     * 登录失败
     */
    public static final String LOGIN_FAILED= "K-000002";
    /**
     * 参数错误
     */
    public static final String PARAM_ERROR = "K-000009";
    /**
     * 缺少token
     */
    public static final String NO_TOKEN = "K-000003";
    /**
     * token失效
     */
    public static final String TOKEN_EXPIRED = "K-000004";
    /**
     * 数据库操作失败
     */
    public static final String EXC_DATABASE_ERROR = "K-000004";
}
