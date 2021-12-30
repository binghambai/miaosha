package com.binghambai.mallorder.pojo.request;

import com.binghambai.mallorder.pojo.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest implements Serializable {
    @NonNull
    private String buyerName;
    @NonNull
    private String buyerPhone;
    @NonNull
    private String consigneeName;
    @NonNull
    private String consigneePhone;
    @NonNull
    private String consigneeAddress;
    @NonNull
    private List<Goods> goodsList;
    @NonNull
    private BigDecimal totalCash;
}
