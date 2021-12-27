package com.binghambai.mallopen.controller;

import com.binghambai.mallopen.jwt.JwtUtils;
import com.binghambai.mallopen.provider.CustomerInfoProvider;
import com.binghambai.mallopen.request.Login;
import com.binghambai.mallopen.response.LoginResponse;
import com.mall.common.provider.response.BaseResponse;
import com.mall.common.provider.response.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    CustomerInfoProvider customerInfoProvider;

    @PostMapping("/login")
    public BaseResponse login(@RequestBody Login login) {
        BaseResponse<LoginResponse> response = customerInfoProvider.login(login);
        if (Objects.isNull(response)) {
            return BaseResponse.FAILED();
        }
        if (!ErrorCode.SUCCESS.equals(response.getCode())) {
            return BaseResponse.info(response.getCode(), response.getMsg());
        }
        LoginResponse user = response.getContext();
        user.setToken(JwtUtils.createToken(user.getUserName(), user.getUserPhone()));
        return response;
    }
}
