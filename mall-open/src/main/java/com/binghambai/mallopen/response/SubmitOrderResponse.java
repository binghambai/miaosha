package com.binghambai.mallopen.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmitOrderResponse implements Serializable {

    private Integer expiredMineTime;
}
