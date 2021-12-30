package com.binghambai.mallorder.pojo.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "mall_order")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class MallOrder {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Column(name = "order_time")
    private String orderTime;

    @Column(name = "logistics_status")
    private Integer logisticsStatus;

    @Column(name = "buyer_name")
    private String buyerName;

    @Column(name = "buyer_phone")
    private String buyerPhone;

    @Column(name = "consignee_name")
    private String consigneeName;

    @Column(name = "consignee_phone")
    private String consigneePhone;

    @Column(name = "consignee_address")
    private String consigneeAddress;

    @Column(name = "goods_list")
    private String goodsList;

    @Column(name = "deal_amount", precision = 30)
    private BigDecimal dealAmount;

    @Column(name = "deal_date")
    private String dealDate;

    @Column(name = "order_status")
    private Integer orderStatus;

    @Column(name = "is_active")
    private Integer isActive;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MallOrder mallOrder = (MallOrder) o;
        return id != null && Objects.equals(id, mallOrder.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}