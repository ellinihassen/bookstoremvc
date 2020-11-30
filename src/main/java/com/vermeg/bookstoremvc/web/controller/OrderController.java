package com.vermeg.bookstoremvc.web.controller;


import com.vermeg.bookstoremvc.dao.entity.Order;
import com.vermeg.bookstoremvc.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController extends GenericController<Order> {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        super(orderService);
        this.orderService = orderService;
    }

    @GetMapping("/user/{id}")
    public List<Order> getAllOrdersByUser(@PathVariable Long id) {
        return orderService.getOrdersByUser(id);
    }

    @GetMapping("/user/{id}/{status}")
    public List<Order> getAllOrdersByUserAndStatus(@PathVariable("id") Long id, @PathVariable("status") String status) {
        return orderService.getOrderByUserAndStatus(id, status);
    }

    @PutMapping("")
    public Order updateOrder(@RequestBody Order order) {
        return orderService.update(order);
    }


}
