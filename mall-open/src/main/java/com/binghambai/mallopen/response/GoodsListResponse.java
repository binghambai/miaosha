package com.binghambai.mallopen.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GoodsListResponse implements Serializable {

    List<GoodsDetailVO> goodsDetailVOS;
}
