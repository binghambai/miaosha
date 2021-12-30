package com.binghambai.mallorder.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {
    @NonNull
    private Long goodsId;
    @NonNull
    private String goodsName;
    @NonNull
    private BigDecimal goodsPrice;
    @NonNull
    private Integer total;

}
