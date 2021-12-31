package com.binghambai.customer.pojo.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "mall_user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MallUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_id")
    private String userId = UUID.randomUUID().toString().replaceAll("-", "");

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_pic")
    private String userPic = "";
}