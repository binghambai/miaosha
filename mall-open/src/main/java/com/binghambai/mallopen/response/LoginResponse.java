package com.binghambai.mallopen.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse implements Serializable {

    private String userId;

    private String userName;

    private String userPic;

    private String userPhone;

    private String token;
}
