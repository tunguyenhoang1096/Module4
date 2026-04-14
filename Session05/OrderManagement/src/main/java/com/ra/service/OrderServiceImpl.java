package com.ra.service;

import com.ra.model.entity.Order;
import com.ra.model.enums.OrderStatus;
import com.ra.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status);
    }

    @Override
    public List<Order> findByCustomerNameContainingIgnoreCase(String name) {
        return orderRepository.findByCustomerNameContainingIgnoreCase(name);
    }

    @Override
    public List<Order> getAllOrdersSorted(String field, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(field).descending()
                : Sort.by(field).ascending();
        return orderRepository.findAll(sort);
    }

    @Override
    public Page<Order> getOrdersPage(int page, int size) {
        PageRequest  pageRequest = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return orderRepository.findAll(pageRequest);
    }

    @Override
    public List<Order> getOrdersGreaterThanAvg() {
        return orderRepository.getOrdersGreaterThanAvg();
    }
}
