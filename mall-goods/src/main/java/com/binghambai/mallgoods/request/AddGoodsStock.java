package com.binghambai.mallgoods.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddGoodsStock implements Serializable {

    private Long goodsId;

    private Integer num;

}
