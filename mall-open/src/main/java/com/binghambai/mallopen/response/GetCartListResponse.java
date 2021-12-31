package com.binghambai.mallopen.response;

import com.binghambai.mallopen.response.vo.GoodsCartItemVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCartListResponse implements Serializable {

    private List<GoodsCartItemVO> goodsCartItemVOList;
}
