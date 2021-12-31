package com.binghambai.mallorder.controller;

import com.binghambai.mallorder.pojo.request.CreateOrderRequest;
import com.binghambai.mallorder.pojo.request.SubmitOrderRequest;
import com.binghambai.mallorder.pojo.response.SubmitOrderResponse;
import com.binghambai.mallorder.provider.GoodsInfoProvider;
import com.binghambai.mallorder.provider.OrderProvider;
import com.binghambai.mallorder.service.OrderService;
import com.mall.common.provider.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderProvider {

    @Autowired
    OrderService orderService;

    @Override
    public BaseResponse create(CreateOrderRequest createOrderRequest) {
        return orderService.createOrder(createOrderRequest);
    }
    @Override
    public BaseResponse  submit(SubmitOrderRequest submitOrderRequest) {
        return orderService.submitOrder(submitOrderRequest);
    }
}
