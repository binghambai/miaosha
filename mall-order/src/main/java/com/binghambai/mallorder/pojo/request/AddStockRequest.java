package com.binghambai.mallorder.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStockRequest implements Serializable {

    private List<AddGoodsStock> addGoodsStockList;
}
