package com.binghambai.customer.repository;

import com.binghambai.customer.pojo.model.MallUserCart;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCartRepository extends JpaRepository<MallUserCart, Long>,
        JpaSpecificationExecutor<MallUserCart> {

    List<MallUserCart> findByUserId(String userId);
}
