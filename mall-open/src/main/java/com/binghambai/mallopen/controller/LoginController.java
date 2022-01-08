package com.binghambai.mallopen.controller;

import com.binghambai.mallopen.jwt.JwtUtils;
import com.binghambai.mallopen.provider.CustomerInfoProvider;
import com.binghambai.mallopen.request.Login;
import com.binghambai.mallopen.response.LoginResponse;
import com.mall.common.provider.pojo.ErrorVerifyBaseResponse;
import com.mall.common.provider.response.BaseResponse;
import com.mall.common.provider.response.ErrorCode;
import com.mall.common.provider.utils.VerifyBaseResponse;
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
        ErrorVerifyBaseResponse verify = VerifyBaseResponse.verify(response);
        if (!ErrorCode.SUCCESS.getCode().equals(verify.getCode())) {
            return BaseResponse.FAILED();
        }
        LoginResponse context = response.getContext();
        String token = JwtUtils.createToken(context);
        context.setToken(token);
        return BaseResponse.success(context);
    }
}
