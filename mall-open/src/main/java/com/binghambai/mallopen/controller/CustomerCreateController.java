package com.binghambai.mallopen.controller;

import com.binghambai.mallopen.provider.CustomerInfoProvider;
import com.binghambai.mallopen.request.Customer;
import com.mall.common.provider.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerCreateController {

    @Autowired
    CustomerInfoProvider customerInfoProvider;

    @PostMapping("/create")
    public BaseResponse customerCreate(@RequestBody Customer customer) {
        return customerInfoProvider.customerCreate(customer);
    }
}
