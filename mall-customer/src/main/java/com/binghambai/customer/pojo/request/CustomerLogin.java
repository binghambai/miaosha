package com.binghambai.customer.pojo.request;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
public class CustomerLogin implements Serializable {
    @NonNull
    private String userName;

    private String phone;
    @NonNull
    private String password;
}
