package com.binghambai.mallopen.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDetailVO implements Serializable {

    private Long goodsId;

    private String name;

    private String desc;

    private BigDecimal price;

    private String imgUrl;
}
