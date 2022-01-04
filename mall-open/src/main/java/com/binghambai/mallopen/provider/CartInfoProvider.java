package com.binghambai.mallopen.provider;

import com.binghambai.mallopen.request.AddToCartRequest;
import com.binghambai.mallopen.request.GetCartListRequest;
import com.binghambai.mallopen.response.GetCartListResponse;
import com.mall.common.provider.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(name = "mall-customer")
public interface CartInfoProvider {

    @RequestMapping("/customer/get/cart-list")
    BaseResponse<GetCartListResponse> getCartList(@RequestBody GetCartListRequest getCartListRequest);

    @RequestMapping("/customer/add-cart")
    BaseResponse addCart(@RequestBody AddToCartRequest addToCartRequest);

}
