package com.binghambai.mallopen.controller;

import com.binghambai.mallopen.provider.OrderInfoProvider;
import com.binghambai.mallopen.request.SubmitOrderRequest;
import com.mall.common.provider.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/order")
public class OrderSubmitController {

    @Autowired
    OrderInfoProvider orderInfoProvider;

    @PostMapping("/submit")
    public BaseResponse submit(@RequestBody @Valid SubmitOrderRequest submitOrderRequest) {
        return orderInfoProvider.submit(submitOrderRequest);
    }
}
