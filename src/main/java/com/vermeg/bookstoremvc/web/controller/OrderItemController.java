package com.vermeg.bookstoremvc.web.controller;

import com.vermeg.bookstoremvc.dao.entity.OrderItem;
import com.vermeg.bookstoremvc.model.OrderItemDTO;
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
    public List<OrderItemDTO> getAllItemByOrder(@PathVariable Long orderId) {
        return orderItemService.getItemsByOrder(orderId);
    }


    @PutMapping("")
    public OrderItemDTO update(@RequestBody OrderItemDTO item) {
        return orderItemService.update(item);
    }


}
