package com.binghambai.mallgoods.provider;


import com.binghambai.mallgoods.request.GoodsListRequest;
import com.binghambai.mallgoods.response.GoodsListResponse;
import com.mall.common.provider.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "${app.goods.name}")
public interface GoodsDetailProvider {

    @PostMapping( "/goods/goods-detail")
    BaseResponse<GoodsListResponse> getGoodsList(@RequestBody GoodsListRequest goodsListRequest);

    @GetMapping("/goods/test")
    String getTest();
}
