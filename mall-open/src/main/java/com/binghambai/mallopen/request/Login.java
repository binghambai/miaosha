package com.binghambai.mallopen.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class Login implements Serializable {

    private String userName;

    private String phone;

    private String password;
}
