package com.ra.controller;

import com.ra.model.entity.Order;
import com.ra.model.enums.OrderStatus;
import com.ra.repository.OrderRepository;
import com.ra.service.OrderService;
import com.ra.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Order> orders =  orderService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/searchByStatus")
    public ResponseEntity<?> findByStatus(@RequestParam("status") OrderStatus status){
        return new ResponseEntity<>(orderService.findByStatus(status), HttpStatus.OK);
    }

    @GetMapping("/searchByCustomerName")
    public ResponseEntity<List<Order>> findByCustomerName(@RequestParam("name") String name){
        return new ResponseEntity<>(orderService.findByCustomerNameContainingIgnoreCase(name), HttpStatus.OK);
    }

    @GetMapping("/sort")
    public ResponseEntity<?> sort(@RequestParam("field") String sortBy, @RequestParam("direction") String dir){
        return ResponseEntity.ok(orderService.getAllOrdersSorted(sortBy,dir));
    }

    @GetMapping("/hight-value")
    public ResponseEntity<?> highValue(){
        return ResponseEntity.ok(orderService.getOrdersGreaterThanAvg());
    }

}
