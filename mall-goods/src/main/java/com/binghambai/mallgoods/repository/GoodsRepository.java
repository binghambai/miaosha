package com.binghambai.mallgoods.repository;


import com.binghambai.mallgoods.model.PmsProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<PmsProductEntity, Long>,
        JpaSpecificationExecutor<PmsProductEntity> {

//    @Query(value = "SELECT a.name, a.price, a.subTitle, a.pic FROM PmsProductEntity a where a.deleteStatus=0 AND a.publishStatus = 1")
    @Query(value = "SELECT a FROM PmsProductEntity a where a.deleteStatus=0 AND a.publishStatus = 1")
    List<PmsProductEntity> getGoodsByPage();
}
