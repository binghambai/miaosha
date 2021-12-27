package com.binghambai.customer.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class LoginResponse implements Serializable {

    private String userName;

    private String userPic;

    private String userPhone;


}
