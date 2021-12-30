package com.binghambai.mallorder.pojo.response;

import com.mall.common.provider.pojo.enums.LogisticsStatusEnum;
import com.mall.common.provider.pojo.enums.OrderActiveStatusEnum;
import com.mall.common.provider.pojo.enums.OrderStatusEnum;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderResponse implements Serializable {

    private String orderId;

    private String orderTime;

    private LogisticsStatusEnum logisticsStatus;

    private BigDecimal dealAmount;

    private String date;

    private OrderStatusEnum orderStatus;

    private OrderActiveStatusEnum isActive;
}
