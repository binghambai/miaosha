package com.binghambai.mallgoods.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsListRequest implements Serializable {
    @NonNull
    private Integer pageNum;
    @NonNull
    private Integer pageSize;
}
