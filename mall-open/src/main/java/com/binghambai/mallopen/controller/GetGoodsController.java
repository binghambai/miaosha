package com.binghambai.mallopen.controller;


import com.binghambai.mallopen.provider.GoodsDetailProvider;
import com.binghambai.mallopen.request.GoodsListRequest;
import com.binghambai.mallopen.response.GoodsListResponse;
import com.mall.common.provider.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/goods/")
public class GetGoodsController {

    @Autowired
    private GoodsDetailProvider goodsDetailProvider;

    @PostMapping("/getAll")
    public BaseResponse<GoodsListResponse> getGoods(@RequestBody GoodsListRequest goodsListRequest) {
        return goodsDetailProvider.getGoodsListAll(goodsListRequest);
    }

    @GetMapping("/test")
    public String get(){
        return "hello";
    }
}
