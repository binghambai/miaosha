package com.binghambai.mallgoods.provider;


import com.binghambai.mallgoods.request.AddGoodsStock;
import com.binghambai.mallgoods.request.AddStockRequest;
import com.binghambai.mallgoods.request.GoodsListRequest;
import com.binghambai.mallgoods.request.ReduceStockRequest;
import com.binghambai.mallgoods.response.GoodsListResponse;
import com.mall.common.provider.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "${app.goods.name}")
public interface GoodsDetailProvider {

    @PostMapping( "/goods/goods-detail")
    BaseResponse<GoodsListResponse> getGoodsList(@RequestBody GoodsListRequest goodsListRequest);

    @PostMapping("/goods/reduce-stock")
    BaseResponse reduceStock(@RequestBody ReduceStockRequest reduceStockRequest);

    @PostMapping("/goods/add-stock")
    BaseResponse addStock(@RequestBody AddStockRequest addStockRequest);
}
