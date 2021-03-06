package com.binghambai.mallopen.controller;

import com.binghambai.mallopen.jwt.JwtUtils;
import com.binghambai.mallopen.provider.CustomerInfoProvider;
import com.binghambai.mallopen.response.LoginResponse;
import com.binghambai.mallopen.response.vo.UserInfoVo;
import com.mall.common.provider.pojo.ErrorVerifyBaseResponse;
import com.mall.common.provider.response.BaseResponse;
import com.mall.common.provider.response.ErrorCode;
import com.mall.common.provider.utils.VerifyBaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api/token")
public class VerifyTokenController {

    @Autowired
    private CustomerInfoProvider customerInfoProvider;

    @GetMapping("/verify")
    public BaseResponse verifyToken(@RequestParam("token") String token) {
        LoginResponse user = JwtUtils.getUser(token);
        if(Objects.isNull(user)){
            return BaseResponse.error(ErrorCode.TOKEN_EXPIRED.getCode(), ErrorCode.TOKEN_EXPIRED.getMsg());
        }
        return BaseResponse.success(user);
    }
}
