package com.binghambai.mallorder.mq.delayedOrder;

import com.alibaba.fastjson.JSONObject;
import com.binghambai.mallorder.pojo.Goods;
import com.binghambai.mallorder.pojo.model.MallOrder;
import com.binghambai.mallorder.pojo.request.AddGoodsStock;
import com.binghambai.mallorder.pojo.request.AddStockRequest;
import com.binghambai.mallorder.pojo.request.SubmitOrderRequest;
import com.binghambai.mallorder.provider.GoodsInfoProvider;
import com.binghambai.mallorder.repository.OrderRepository;
import com.mall.common.provider.Exception.SbcException;
import com.mall.common.provider.pojo.enums.OrderStatusEnum;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class DelayedOrderConsumer {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    GoodsInfoProvider goodsInfoProvider;

    @RabbitListener(queues = DelayedOrderRabbitMQConfig.DELAYED_QUEUE_NAME)
    public void consumerMsg(@Payload Message msg, Channel channel) throws IOException {

        String javaMsg = new String(msg.getBody());
        String jsonMsg = StringEscapeUtils.unescapeJava(javaMsg);
        String jsonMsgRes = StringUtils.strip(jsonMsg, "\"");
        SubmitOrderRequest submitOrderRequest = JSONObject.parseObject(jsonMsgRes, SubmitOrderRequest.class);

        //检查当前订单是否支付
        MallOrder order = orderRepository.findByOrderId(submitOrderRequest.getOrderId());
        String payed = null;
        try {
            if(OrderStatusEnum.NO_PAYMENT.getIndex().equals(order.getOrderStatus())) {
                //未支付 修改订单状态
                log.error("未支付");
                payed = "未支付";
                orderRepository.cancel(submitOrderRequest.getOrderId());

                //返回库存
                List<AddGoodsStock>  addGoodsStockList = new ArrayList<>();
                for (Goods goods : submitOrderRequest.getGoodsList()) {
                    addGoodsStockList.add(new AddGoodsStock(goods.getGoodsId(), goods.getTotal()));
                }
                goodsInfoProvider.addStock(new AddStockRequest(addGoodsStockList));
            } else if (!OrderStatusEnum.CANCELLED.getIndex().equals(order.getOrderStatus())){
                payed = "已支付";
            } else {
                payed = "已作废";
            }
        } catch (Exception e) {
            log.error(e.toString());
            throw new SbcException(e.toString());
        } finally {
            channel.basicAck(msg.getMessageProperties().getDeliveryTag(), false);
        }
        //false关闭自动应答
        log.info("消费时间:{}, 订单id:{}, 订单状态:{}", new Date(), submitOrderRequest.getOrderId(), payed);
    }
}
