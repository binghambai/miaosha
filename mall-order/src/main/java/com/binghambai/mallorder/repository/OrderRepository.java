package com.binghambai.mallorder.repository;

import com.binghambai.mallorder.pojo.model.MallOrder;
import com.binghambai.mallorder.pojo.request.SubmitOrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<MallOrder, Long>, JpaSpecificationExecutor<MallOrder> {

    MallOrder findByOrderId(String orderId);

    @Transactional
    @Modifying
    @Query(value = "update MallOrder m set m.buyerName = :#{#req.buyerName}, m.buyerPhone = :#{#req.buyerPhone}," +
            " m.consigneeAddress = :#{#req.consigneeAddress}, m.consigneeName = :#{#req.consigneeAddress}," +
            " m.consigneePhone = :#{#req.consigneePhone} where m.orderId = :#{#req.orderId}", nativeQuery = false)
    void saveConsigneeInfo(@Param("req") SubmitOrderRequest req);

    @Transactional
    @Modifying
    @Query(value = "update MallOrder m set m.orderStatus = 5, m.isActive = 0 where m.orderId = :#{#orderId}")
    void cancel(@Param("orderId") String orderId);

}
