package com.binghambai.mallgoods.service;

import com.binghambai.mallgoods.model.PmsProductEntity;
import com.binghambai.mallgoods.repository.GoodsRepository;
import com.binghambai.mallgoods.request.GoodsListRequest;
import com.binghambai.mallgoods.response.GoodsDetailVO;
import com.binghambai.mallgoods.response.GoodsListResponse;
import com.mall.common.provider.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
}
