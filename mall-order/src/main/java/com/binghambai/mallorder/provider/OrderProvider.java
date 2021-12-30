package com.binghambai.mallorder.provider;

import com.binghambai.mallorder.pojo.request.CreateOrderRequest;
import com.mall.common.provider.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(value = "${app.order.name}")
public interface OrderProvider {

    @PostMapping("/order/create")
    BaseResponse create(@RequestBody CreateOrderRequest createOrderRequest);

}
