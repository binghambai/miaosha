package com.binghambai.customer.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToCartRequest implements Serializable{
    @NonNull
    private Long goodsId;
    @NonNull
    private String userId;
    @NonNull
    private String goodsName;

    private String goodsPic;
    @NonNull
    private String goodsDesc;
    @NonNull
    private BigDecimal goodsPrice;
    @NonNull
    private Integer num;
}