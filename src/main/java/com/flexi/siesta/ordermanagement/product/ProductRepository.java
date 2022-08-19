package com.flexi.siesta.ordermanagement.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    //@Query(value = "select m from Product m WHERE m.productCode = :productCode")
    Optional<Product> findOneByProductCode(String productCode);
}
