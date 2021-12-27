package com.binghambai.customer.repository;

import com.binghambai.customer.pojo.model.MallUser;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<MallUser, Long> , JpaSpecificationExecutor<MallUser> {

    boolean existsByUserPhone(String userPhone);

    MallUser findByUserNameAndUserPassword(String userName, String userPassword);

    MallUser findByUserPhone(String phone);
}
