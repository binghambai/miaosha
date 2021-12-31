package com.binghambai.mallopen.request;

import com.binghambai.mallopen.request.dto.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmitOrderRequest implements Serializable {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String consigneeName;

    private String consigneePhone;

    private String consigneeAddress;

    private List<Goods> goodsList;
}
