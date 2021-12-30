package com.mall.common.provider.pojo.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderActiveStatusEnum {
    NO_ACTIVE,
    ACTIVE;

    @JsonCreator
    public static OrderActiveStatusEnum getByIndex(Integer index) {
        for (OrderActiveStatusEnum value : OrderActiveStatusEnum.values()) {
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
