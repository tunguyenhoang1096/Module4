package com.ra.service;

import com.ra.model.entity.Order;
import com.ra.model.enums.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderService{
    List<Order> findAll();
    List<Order> findByStatus(OrderStatus status);
    List<Order> findByCustomerNameContainingIgnoreCase(String name);
    List<Order> getAllOrdersSorted(String field, String direction);
    Page<Order> getOrdersPage(int page, int size);


    List<Order> getOrdersGreaterThanAvg();
}
