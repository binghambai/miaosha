package com.binghambai.mallopen.provider;

import com.binghambai.mallopen.request.CreateOrderRequest;
import com.binghambai.mallopen.request.SubmitOrderRequest;
import com.binghambai.mallopen.response.CreateOrderResponse;
import com.binghambai.mallopen.response.SubmitOrderResponse;
import com.mall.common.provider.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@FeignClient(name = "mall-order")
public interface OrderInfoProvider {

    @RequestMapping("/order/create")
    BaseResponse<CreateOrderResponse> createOrder(CreateOrderRequest createOrderRequest);

    @RequestMapping("/order/submit")
    BaseResponse<SubmitOrderResponse> submit(SubmitOrderRequest submitOrderRequest);
}
