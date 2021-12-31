package com.binghambai.customer.provider;

import com.binghambai.customer.pojo.request.AddToCartRequest;
import com.binghambai.customer.pojo.request.GetCartListRequest;
import com.mall.common.provider.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "${app.customer.name}")
public interface GetCartListProvider {

    @PostMapping("/customer/get/cart-list")
    BaseResponse getCartList(@RequestBody GetCartListRequest getCartListRequest);

    @PostMapping("/customer/add-cart")
    BaseResponse addCart(@RequestBody AddToCartRequest addToCartRequest);
}
