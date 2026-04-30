package org.example.bai2.repository;


import org.example.bai2.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query("UPDATE Order o SET o.status = 'CANCELLED' WHERE o.id = :orderId AND o.status != 'DELIVERED'")
    int cancelFraudulentOrder(@Param("orderId") Long orderId);
}
