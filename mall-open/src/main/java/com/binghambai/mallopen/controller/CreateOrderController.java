package com.binghambai.mallopen.controller;

import com.binghambai.mallopen.provider.OrderInfoProvider;
import com.binghambai.mallopen.request.CreateOrderRequest;
import com.binghambai.mallopen.response.CreateOrderResponse;
import com.mall.common.provider.Exception.SbcException;
import com.mall.common.provider.response.BaseResponse;
import com.mall.common.provider.response.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/order")
public class CreateOrderController {

    @Autowired
    OrderInfoProvider orderInfoProvider;

    @PostMapping("/create")
    public BaseResponse create(@RequestBody @Valid CreateOrderRequest createOrderRequest) {
        try {
            return orderInfoProvider.createOrder(createOrderRequest);
        } catch (Exception e) {
            throw new SbcException(e.toString());
        }
    }
}
