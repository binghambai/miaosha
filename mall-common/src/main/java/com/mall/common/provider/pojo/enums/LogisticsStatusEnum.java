package com.mall.common.provider.pojo.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LogisticsStatusEnum {
    NO_DELIVERED,
    DELIVERED,
    RECEIVED;

    //εεΊεε
    @JsonCreator
    public static LogisticsStatusEnum getByIndex(Integer index) {
        for (LogisticsStatusEnum value : LogisticsStatusEnum.values()) {
            if (value.ordinal() == index) {
                return value;
            }
        }
        return null;
    }

    @JsonValue
    public Integer getIndex(){
        return ordinal();
    }
}
