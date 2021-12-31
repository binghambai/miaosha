package com.binghambai.mallopen.response;

import com.binghambai.mallopen.response.vo.GoodsDetailVO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GoodsListResponse implements Serializable {

    List<GoodsDetailVO> goodsDetailVOS;
}
