package com.binghambai.customer.service;

import com.binghambai.customer.pojo.model.MallUserCart;
import com.binghambai.customer.pojo.request.AddToCartRequest;
import com.binghambai.customer.pojo.request.GetCartListRequest;
import com.binghambai.customer.pojo.response.GetCartListResponse;
import com.binghambai.customer.pojo.response.vo.GoodsCartItemVO;
import com.binghambai.customer.repository.UserCartRepository;
import com.mall.common.provider.response.BaseResponse;
import com.mall.common.provider.response.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
@Slf4j
public class UserCartService {

    @Autowired
    UserCartRepository userCartRepository;

    public BaseResponse getCartList(GetCartListRequest getCartListRequest) {
        List<MallUserCart> mallUserCartList = userCartRepository.findByUserId(getCartListRequest.getUserId());

        List<GoodsCartItemVO> goodsCartItemVOS = new ArrayList<>();
        for (MallUserCart goods : mallUserCartList) {
            GoodsCartItemVO goodsCartItemVO = new GoodsCartItemVO();
            goodsCartItemVO.setGoodsPic(goods.getGoodsPic());
            goodsCartItemVO.setGoodsDesc(goods.getGoodsDesc());
            goodsCartItemVO.setGoodsName(goods.getGoodsName());
            goodsCartItemVO.setGoodsPrice(goods.getPrice());
            goodsCartItemVO.setNum(goods.getNum());
            goodsCartItemVOS.add(goodsCartItemVO);
        }
        return BaseResponse.success(new GetCartListResponse(goodsCartItemVOS));
    }

    public BaseResponse addToCart(AddToCartRequest addToCartRequest) {
        if (addToCartRequest.getNum() <= 0) {
            return BaseResponse.error(ErrorCode.FAILED.getCode(), ErrorCode.FAILED.getMsg());
        }
        MallUserCart mallUserCart = new MallUserCart();
        mallUserCart.setUserId(addToCartRequest.getUserId());
        mallUserCart.setGoodsId(addToCartRequest.getGoodsId());
        mallUserCart.setGoodsDesc(addToCartRequest.getGoodsDesc());
        mallUserCart.setGoodsName(addToCartRequest.getGoodsName());
        mallUserCart.setGoodsPic(addToCartRequest.getGoodsPic());
        mallUserCart.setNum(addToCartRequest.getNum());
        mallUserCart.setPrice(addToCartRequest.getGoodsPrice());
        Date date = new Date(System.currentTimeMillis());
        Timestamp timestamp = new Timestamp(date.getTime());

        mallUserCart.setAddTime(timestamp);
        try {
            userCartRepository.save(mallUserCart);
        } catch (Exception e) {
            log.error("加入购物车出错:{} 用户id：{}", e.toString(), addToCartRequest.getUserId());
        }
        return BaseResponse.SUCCESSFUL();
    }
}
