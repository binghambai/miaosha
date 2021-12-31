package com.binghambai.mallorder.provider;

import com.binghambai.mallorder.pojo.request.AddStockRequest;
import com.binghambai.mallorder.pojo.request.ReduceStockRequest;
import com.mall.common.provider.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "mall-goods")
public interface GoodsInfoProvider {

    @RequestMapping("/goods/reduce-stock")
    BaseResponse reduceStock(ReduceStockRequest reduceStockRequest);

    @RequestMapping("/goods/add-stock")
    BaseResponse addStock(AddStockRequest addStockRequest);
}
