package com.binghambai.mallopen.provider;

import com.binghambai.mallopen.request.GoodsListRequest;
import com.binghambai.mallopen.response.GoodsListResponse;
import com.mall.common.provider.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "mall-goods")
public interface GoodsDetailProvider {
    @RequestMapping("/goods/goods-detail")
    BaseResponse<GoodsListResponse> getGoodsListAll(GoodsListRequest goodsListRequest);


}
