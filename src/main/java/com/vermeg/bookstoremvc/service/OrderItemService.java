package com.vermeg.bookstoremvc.service;

import com.vermeg.bookstoremvc.dao.entity.Book;

import com.vermeg.bookstoremvc.dao.entity.OrderItem;
import com.vermeg.bookstoremvc.model.OrderItemDTO;

import java.util.List;


public interface OrderItemService extends GenericService<OrderItem>{

    public OrderItemDTO update(OrderItemDTO orderItem);
    public List<OrderItemDTO> getItemsByOrder(Long id);


}
