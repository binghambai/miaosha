package com.binghambai.customer.controller;

import com.binghambai.customer.pojo.request.Customer;
import com.binghambai.customer.pojo.request.CustomerLogin;
import com.binghambai.customer.provider.CustomerProcessProvider;
import com.binghambai.customer.service.CustomerInfoService;
import com.mall.common.provider.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerInfoController implements CustomerProcessProvider {

    @Autowired
    CustomerInfoService customerInfoService;

    @Override
    public BaseResponse createCustomer(Customer customer) {
        return customerInfoService.createCustomer(customer);
    }

    @Override
    public BaseResponse login(CustomerLogin customerLogin) {
        return customerInfoService.login(customerLogin);
    }

    @Override
    public BaseResponse getUserInfoByPhone(String phone) {
        return customerInfoService.getUserInfoByPhone(phone);
    }
}
