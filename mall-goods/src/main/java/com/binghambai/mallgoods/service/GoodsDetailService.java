package com.binghambai.mallgoods.service;

import com.binghambai.mallgoods.model.PmsProductEntity;
import com.binghambai.mallgoods.repository.GoodsRepository;
import com.binghambai.mallgoods.request.*;
import com.binghambai.mallgoods.response.GoodsDetailVO;
import com.binghambai.mallgoods.response.GoodsListResponse;
import com.binghambai.mallgoods.response.ReduceStockResponse;
import com.mall.common.provider.response.BaseResponse;
import com.mall.common.provider.response.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.mall.common.provider.response.ErrorCode.NO_STOCK;
import static javax.management.remote.JMXConnectionNotification.FAILED;

@Service
@Slf4j
public class GoodsDetailService {

    @Autowired
    GoodsRepository goodsRepository;

    public BaseResponse<GoodsListResponse> getGoodsByPage(GoodsListRequest goodsListRequest) {
        List<PmsProductEntity> goods = goodsRepository.getGoodsByPage();
        List<GoodsDetailVO> goodsDetailVOs = new ArrayList<>();
        for (PmsProductEntity good : goods) {
            GoodsDetailVO goodsDetailVO = new GoodsDetailVO();
            goodsDetailVO.setDesc(good.getSubTitle());
            goodsDetailVO.setName(good.getName());
            goodsDetailVO.setImgUrl(good.getPic());
            goodsDetailVO.setPrice(good.getPrice());
            goodsDetailVO.setGoodsId(good.getId());
            goodsDetailVOs.add(goodsDetailVO);
        }
        GoodsListResponse goodsListResponse = new GoodsListResponse();
        goodsListResponse.setGoodsDetailVOS(goodsDetailVOs);
        return BaseResponse.success(goodsListResponse);
    }

    public BaseResponse reduceStock(ReduceStockRequest reduceStockRequest) {
        List<Long> noStockGoodsId = new ArrayList<>();
        for (GoodsStock goods : reduceStockRequest.getGoodsIdList()) {
            //查询库存
            int stock = goodsRepository.getStock(goods.getGoodsId());
            if (stock <= 0 || stock < goods.getNum()) {
                noStockGoodsId.add(goods.getGoodsId());
            } else {
                //扣库存
                try {
                    goodsRepository.updateStock(stock - goods.getNum(), goods.getGoodsId());
                } catch (Exception e) {
                    log.error("扣库存失败:{}", e.toString());
                    noStockGoodsId.add(goods.getGoodsId());
                }
            }
        }
        return BaseResponse.success(new ReduceStockResponse(noStockGoodsId));
    }

    public BaseResponse addGoodsStock(AddStockRequest addStockRequest) {
        for (AddGoodsStock goodsStock : addStockRequest.getAddGoodsStockList()) {
            try {
                goodsRepository.updateStock(goodsStock.getNum(), goodsStock.getGoodsId());
            } catch (Exception e) {
                log.error("返还库存失败:{}, 商品Id:{} 返还个数:{}", e.toString(), goodsStock.getGoodsId(), goodsStock.getNum());
            }
        }
        return BaseResponse.SUCCESSFUL();
    }
}
