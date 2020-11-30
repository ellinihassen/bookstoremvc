package com.vermeg.bookstoremvc.service;

import com.vermeg.bookstoremvc.dao.entity.Order;


import java.util.List;

public interface OrderService extends GenericService<Order>{

    public Order update(Order order);

    public List<Order> getOrdersByUser(Long id);

    public List<Order> getOrderByUserAndStatus(Long id,String status);

    public Order validateOrder(Order order);
}
