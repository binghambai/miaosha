package com.binghambai.mallopen.provider;

import com.binghambai.mallopen.request.AddToCartRequest;
import com.binghambai.mallopen.request.Customer;
import com.binghambai.mallopen.request.GetCartListRequest;
import com.binghambai.mallopen.request.Login;
import com.binghambai.mallopen.response.GetCartListResponse;
import com.binghambai.mallopen.response.LoginResponse;
import com.binghambai.mallopen.response.vo.UserInfoVo;
import com.mall.common.provider.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "mall-customer")
public interface CustomerInfoProvider {

    @RequestMapping("/customer/1.0.0/create")
    BaseResponse customerCreate(Customer customer);

    @RequestMapping("/customer/login")
    BaseResponse<LoginResponse> login(Login login);

    @RequestMapping("/customer/get-user-info")
    BaseResponse<UserInfoVo> getUserInfoByPhone(@RequestParam("phone") String phone);
}
