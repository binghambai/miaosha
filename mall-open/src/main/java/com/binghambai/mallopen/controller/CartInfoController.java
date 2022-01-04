package com.binghambai.mallopen.controller;

import com.binghambai.mallopen.provider.CartInfoProvider;
import com.binghambai.mallopen.provider.CustomerInfoProvider;
import com.binghambai.mallopen.request.AddToCartRequest;
import com.binghambai.mallopen.request.GetCartListRequest;
import com.binghambai.mallopen.response.GetCartListResponse;
import com.mall.common.provider.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartInfoController {

    @Autowired
    CartInfoProvider cartInfoProvider;

    @PostMapping("/getCartList")
    public BaseResponse<GetCartListResponse> getCartList(@RequestBody GetCartListRequest getCartListRequest) {
        return cartInfoProvider.getCartList(getCartListRequest);
    }

    @PostMapping("/add")
    public BaseResponse addCart(@RequestBody AddToCartRequest addToCartRequest) {
        return cartInfoProvider.addCart(addToCartRequest);
    }
}
