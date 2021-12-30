package com.mall.common.provider.response;

import lombok.Data;

public enum ErrorCode {
    SUCCESS("K-000000", "成功"),
    FAILED("K-000001", "失败"),
    LOGIN_FAILED("K-000002", "登录失败"),
    PARAM_ERROR("K-000009", "参数错误"),
    NO_TOKEN("K-000003", "缺少token"),
    TOKEN_EXPIRED("K-000004", "token失效"),
    EXC_DATABASE_ERROR("K-000006", "数据库操作失败"),
    ERROR_CREATE_ORDER("K-000005", "生成订单出错");

    private String code;

    private String msg;

    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

}
