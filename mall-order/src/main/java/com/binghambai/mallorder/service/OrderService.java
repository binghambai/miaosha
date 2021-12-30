package com.binghambai.mallorder.service;

import com.binghambai.mallorder.pojo.Goods;
import com.mall.common.provider.pojo.enums.LogisticsStatusEnum;
import com.mall.common.provider.pojo.enums.OrderActiveStatusEnum;
import com.mall.common.provider.pojo.enums.OrderStatusEnum;
import com.binghambai.mallorder.pojo.model.MallOrder;
import com.binghambai.mallorder.pojo.request.CreateOrderRequest;
import com.binghambai.mallorder.pojo.response.CreateOrderResponse;
import com.binghambai.mallorder.repository.OrderRepository;
import com.mall.common.provider.Exception.SbcException;
import com.mall.common.provider.response.BaseResponse;
import com.mall.common.provider.response.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public BaseResponse createOrder(CreateOrderRequest createOrderRequest) {

        //校验交易金额
        BigDecimal sum = BigDecimal.ZERO;
        List<String> goodsIdList = new ArrayList<>();
        for (Goods goods : createOrderRequest.getGoodsList()) {
            sum = sum.add(goods.getGoodsPrice());
            goodsIdList.add(goods.getGoodsId().toString());
        }
        if (sum.compareTo(createOrderRequest.getTotalCash()) != 0) {
            log.error("总金额价格有误");
            throw new SbcException("总金额价格有误");
        }
        MallOrder mallOrder = new MallOrder();
        String orderId = generateOrderId();
        mallOrder.setOrderId(orderId);

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String orderCreateDate = sdf.format(date);

        mallOrder.setOrderTime(orderCreateDate);
        //默认状态
        mallOrder.setOrderStatus(OrderStatusEnum.NO_PAYMENT.getIndex());
        mallOrder.setLogisticsStatus(LogisticsStatusEnum.NO_DELIVERED.getIndex());
        mallOrder.setIsActive(OrderActiveStatusEnum.NO_ACTIVE.getIndex());

        mallOrder.setDealAmount(sum);

        mallOrder.setBuyerName(createOrderRequest.getBuyerName());
        mallOrder.setBuyerPhone(createOrderRequest.getBuyerPhone());
        mallOrder.setConsigneeName(createOrderRequest.getConsigneeName());
        mallOrder.setConsigneePhone(createOrderRequest.getConsigneePhone());
        mallOrder.setConsigneeAddress(createOrderRequest.getConsigneeAddress());

        //goodsList json转换
        String jsonGoodsIds = StringUtils.join(goodsIdList, ",");
        mallOrder.setGoodsList(jsonGoodsIds);
        //存入数据库
        try {
            orderRepository.save(mallOrder);
        } catch (Exception e) {
            log.error("生成订单出错");
            return BaseResponse.error(ErrorCode.EXC_DATABASE_ERROR.getCode(), ErrorCode.ERROR_CREATE_ORDER.getMsg());
        }

        //构造返回体
        CreateOrderResponse response = CreateOrderResponse.builder()
                .orderId(orderId)
                .logisticsStatus(LogisticsStatusEnum.NO_DELIVERED)
                .orderStatus(OrderStatusEnum.NO_PAYMENT)
                .orderTime(orderCreateDate)
                .dealAmount(sum)
                .isActive(OrderActiveStatusEnum.NO_ACTIVE)
                .build();
        return BaseResponse.success(response);

    }

    private String generateOrderId() {
        String random = RandomStringUtils.randomNumeric(4);
        Date date = new Date(System.currentTimeMillis());
        return "O" + random + date.getTime();
    }
    public static void main(String[] args) {
//        String random = RandomStringUtils.randomNumeric(4);
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String format = sdf.format(date);
        System.out.println(format);
    }
}
