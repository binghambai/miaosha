package com.binghambai.mallopen.response.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsCartItemVO implements Serializable {

    private String goodsName;

    private String goodsPic;

    private String goodsDesc;

    private BigDecimal goodsPrice;

    private Integer num;
}
