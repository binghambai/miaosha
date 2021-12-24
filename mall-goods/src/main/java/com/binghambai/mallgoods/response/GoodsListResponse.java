package com.binghambai.mallgoods.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GoodsListResponse implements Serializable {

    List<GoodsDetailVO> goodsDetailVOS;
}
