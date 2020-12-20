package com.vermeg.bookstoremvc.service;

import com.vermeg.bookstoremvc.dao.entity.Order;
import com.vermeg.bookstoremvc.model.OrderDTO;


import java.util.List;

public interface OrderService extends GenericService<Order>{

    public OrderDTO update(OrderDTO order);

    public List<OrderDTO> getOrdersByUser(Long id);

    public List<OrderDTO> getOrderByUserAndStatus(Long id,String status);

    public OrderDTO validateOrder(OrderDTO order);
}
