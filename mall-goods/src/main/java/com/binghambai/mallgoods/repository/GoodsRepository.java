package com.binghambai.mallgoods.repository;


import com.binghambai.mallgoods.model.PmsProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<PmsProductEntity, Long>,
        JpaSpecificationExecutor<PmsProductEntity> {

    @Query(value = "SELECT a FROM PmsProductEntity a where a.deleteStatus=0 AND a.publishStatus = 1")
    List<PmsProductEntity> getGoodsByPage();

    @Transactional
    @Modifying
    @Query("update PmsProductEntity p set p.stock = :#{#stock} where p.id = :#{#goodsId}")
    void updateStock(@Param("stock") Integer stock, @Param("goodsId") Long goodsId);

    @Query("select p.stock from PmsProductEntity p where p.id = :#{#goodsId}")
    int getStock(@Param("goodsId") Long goodsId);
}
