package com.binghambai.mallopen.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
