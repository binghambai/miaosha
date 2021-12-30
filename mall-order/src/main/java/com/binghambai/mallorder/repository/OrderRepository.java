package com.binghambai.mallorder.repository;

import com.binghambai.mallorder.pojo.model.MallOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<MallOrder, Long>, JpaSpecificationExecutor<MallOrder> {
}
