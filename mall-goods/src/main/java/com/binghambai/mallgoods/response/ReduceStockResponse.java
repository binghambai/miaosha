package com.binghambai.mallgoods.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReduceStockResponse implements Serializable {

    private List<Long> noStockGoodsIds;
}
