package com.binghambai.mallopen.provider;

import com.binghambai.mallopen.request.Customer;
import com.binghambai.mallopen.request.Login;
import com.binghambai.mallopen.response.LoginResponse;
import com.binghambai.mallopen.response.UserInfoVo;
import com.mall.common.provider.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "mall-customer")
public interface CustomerInfoProvider {

    @RequestMapping("/customer/1.0.0/create")
    BaseResponse customerCreate(Customer customer);

    @RequestMapping("/customer/login")
    BaseResponse<LoginResponse> login(Login login);

    @RequestMapping("/customer/get-user-info")
    BaseResponse<UserInfoVo> getUserInfoByPhone(String phone);
}
