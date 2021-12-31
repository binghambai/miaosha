package com.binghambai.mallgoods.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReduceStockRequest implements Serializable {
    @NonNull
    private List<GoodsStock> goodsIdList;
}
