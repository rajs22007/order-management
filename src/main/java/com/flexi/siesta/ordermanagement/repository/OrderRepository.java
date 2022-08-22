package com.flexi.siesta.ordermanagement.repository;

import com.flexi.siesta.ordermanagement.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderInfo, String> {
}
