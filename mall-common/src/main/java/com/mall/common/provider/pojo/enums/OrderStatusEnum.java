package com.mall.common.provider.pojo.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatusEnum {
    NO_PAYMENT,
    PAID,
    REFUND_ING,
    REFUNDED,
    REFUND_FAILED,
    CANCELLED;

    @JsonCreator
    public static OrderStatusEnum getByIndex(Integer index) {
        for (OrderStatusEnum value : OrderStatusEnum.values()) {
            if (value.ordinal() == index) {
                return value;
            }
        }
        return null;
    }

    @JsonValue
    public Integer getIndex() {
        return ordinal();
    }
}
