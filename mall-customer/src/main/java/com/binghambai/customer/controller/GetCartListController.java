package com.binghambai.customer.controller;

import com.binghambai.customer.pojo.request.AddToCartRequest;
import com.binghambai.customer.pojo.request.GetCartListRequest;
import com.binghambai.customer.provider.GetCartListProvider;
import com.binghambai.customer.service.UserCartService;
import com.mall.common.provider.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetCartListController implements GetCartListProvider {

    @Autowired
    UserCartService userCartService;

    @Override
    public BaseResponse getCartList(GetCartListRequest getCartListRequest) {
        return userCartService.getCartList(getCartListRequest);
    }


    @Override
    public BaseResponse addCart(AddToCartRequest addToCartRequest) {
        return userCartService.addToCart(addToCartRequest);
    }
}
