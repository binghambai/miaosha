package com.binghambai.customer.provider;

import com.binghambai.customer.pojo.request.Customer;
import com.binghambai.customer.pojo.request.CustomerLogin;
import com.mall.common.provider.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@FeignClient(value = "${app.customer.name}")
public interface CustomerProcessProvider {

    @PostMapping("/customer/1.0.0/create")
    BaseResponse createCustomer(@RequestBody @Valid Customer customer);

    @PostMapping("/customer/login")
    BaseResponse login(@RequestBody @Valid CustomerLogin customerLogin);

    @GetMapping("/customer/get-user-info")
    BaseResponse getUserInfoByPhone(String phone);
}
