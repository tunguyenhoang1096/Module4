package com.ra.repository;

import com.ra.model.entity.Order;
import com.ra.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByStatus(OrderStatus status);
    List<Order> findByCustomerNameContainingIgnoreCase(String name);

    @Query("select o from Order o where o.totalPrice > (select avg(o2.totalPrice) from Order o2 where month(o2.createdAt)=month(current_date)) ")
    List<Order> getOrdersGreaterThanAvg();
}
