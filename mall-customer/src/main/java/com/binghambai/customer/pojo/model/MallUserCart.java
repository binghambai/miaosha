package com.binghambai.customer.pojo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "mall_user_cart")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MallUserCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "num")
    private Integer num;

    @Column(name = "price", precision = 30, scale = 2)
    private BigDecimal price;

    @Column(name = "goods_id")
    private Long goodsId;

    @Column(name = "goods_pic")
    private String goodsPic;

    @Column(name = "goods_desc")
    private String goodsDesc;

    @Column(name = "is_delete")
    private Integer isDelete = 0;

    @Column(name = "user_id")
    private String userId;

}