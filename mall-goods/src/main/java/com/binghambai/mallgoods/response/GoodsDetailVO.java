package com.binghambai.mallgoods.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class GoodsDetailVO implements Serializable {

    private String name;

    private String desc;

    private BigDecimal price;

    private String imgUrl;
}
