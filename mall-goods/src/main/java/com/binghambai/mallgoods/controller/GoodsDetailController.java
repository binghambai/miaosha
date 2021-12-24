package com.binghambai.mallgoods.controller;


import com.binghambai.mallgoods.provider.GoodsDetailProvider;
import com.binghambai.mallgoods.request.GoodsListRequest;
import com.binghambai.mallgoods.response.GoodsListResponse;
import com.binghambai.mallgoods.service.GoodsDetailService;
import com.mall.common.provider.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsDetailController implements GoodsDetailProvider {

    @Autowired
    GoodsDetailService goodsDetailService;

    @Override
    public BaseResponse<GoodsListResponse> getGoodsList(GoodsListRequest goodsListRequest) {
        return goodsDetailService.getGoodsByPage(goodsListRequest);
    }

    @Override
    public String getTest() {
        return "test";
    }
}
