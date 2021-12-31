package com.binghambai.mallopen.response.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoVo {

    private Integer id;

    private String userName;

    private String userId;

    private String userPhone;

    private String userPic;
}
