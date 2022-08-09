package com.test.espana.zara.repository;

import com.test.espana.zara.repository.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<Prices,Integer> {
    List<Prices>  findByProductIdAndBrandId(int productId, int brandId);
}
