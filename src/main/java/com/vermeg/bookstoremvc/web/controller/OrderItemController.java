package com.vermeg.bookstoremvc.web.controller;

import com.vermeg.bookstoremvc.dao.entity.OrderItem;
import com.vermeg.bookstoremvc.service.OrderItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class OrderItemController extends GenericController<OrderItem> {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        super(orderItemService);
        this.orderItemService = orderItemService;
    }


    @GetMapping("/order/{orderId}")
    public List<OrderItem> getAllItemByOrder(@PathVariable Long orderId) {
        return orderItemService.getItemsByOrder(orderId);
    }


    @PutMapping("")
    public OrderItem update(@RequestBody OrderItem item) {
        return orderItemService.update(item);
    }


}
