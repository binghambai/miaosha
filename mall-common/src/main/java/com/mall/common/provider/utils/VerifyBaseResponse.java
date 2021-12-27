package com.mall.common.provider.utils;

import com.mall.common.provider.pojo.ErrorVerifyBaseResponse;
import com.mall.common.provider.response.BaseResponse;
import com.mall.common.provider.response.ErrorCode;

import java.util.Objects;

public class VerifyBaseResponse {

    public static ErrorVerifyBaseResponse verify(BaseResponse response) {
        if (Objects.isNull(response)) {
            return new ErrorVerifyBaseResponse(ErrorCode.FAILED, "操作失败");
        }
        if (!ErrorCode.SUCCESS.equals(response.getCode())) {
            return new ErrorVerifyBaseResponse(response.getCode(), response.getMsg());
        }
        if(Objects.isNull(response.getContext())) {
            return new ErrorVerifyBaseResponse(ErrorCode.FAILED, "执行内容为空");
        }
        return new ErrorVerifyBaseResponse(ErrorCode.SUCCESS, "操作成功");
    }
}
