package com.binghambai.customer.pojo.request;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    @NonNull
    private String customerName;
    @NonNull
    private String customerPhone;
    @NonNull
    private String customerPassword;

}
