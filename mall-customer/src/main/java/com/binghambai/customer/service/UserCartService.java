package com.binghambai.customer.service;

import com.binghambai.customer.pojo.model.MallUser;
import com.binghambai.customer.pojo.model.MallUserCart;
import com.binghambai.customer.pojo.request.AddToCartRequest;
import com.binghambai.customer.pojo.request.GetCartListRequest;
import com.binghambai.customer.pojo.request.GetUsersRequest;
import com.binghambai.customer.pojo.response.GetCartListResponse;
import com.binghambai.customer.pojo.response.vo.GoodsCartItemVO;
import com.binghambai.customer.pojo.vo.Users;
import com.binghambai.customer.repository.CustomerRepository;
import com.binghambai.customer.repository.UserCartRepository;
import com.mall.common.provider.response.BaseResponse;
import com.mall.common.provider.response.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class UserCartService {

    @Autowired
    UserCartRepository userCartRepository;

    @Autowired
    CustomerRepository customerRepository;

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

    public void selectUsers(GetUsersRequest request) {
        Pageable pageable = PageRequest.of(request.getPageNum(), request.getPageSize(), Sort.Direction.DESC, "id");
        List<Users> list = customerRepository.findByUserNameLike(request.getUserName(), pageable);
        System.out.println(list);
    }

    public void batchUser() {
        try {
            for (int i = 0; i < 10000; i++) {
                MallUser user = new MallUser();

                user.setUserPhone(randomPhone());
                user.setUserName(randomName());
                user.setUserPassword(randomPhone());

                customerRepository.save(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String randomPhone() {
        String str = "0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            int index = random.nextInt(10);
            sb.append(str.charAt(index));
        }
        return sb.toString();
    }

    private String randomName(){
        String str = "abcdefghijk";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(str.length());
            sb.append(str.charAt(index));
        }
        return sb.toString();
    }
}
