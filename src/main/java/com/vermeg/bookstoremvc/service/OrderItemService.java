package com.vermeg.bookstoremvc.service;

import com.vermeg.bookstoremvc.dao.entity.Book;

import com.vermeg.bookstoremvc.dao.entity.OrderItem;

import java.util.List;


public interface OrderItemService extends GenericService<OrderItem>{

    public OrderItem update(OrderItem orderItem);
    public List<OrderItem> getItemsByOrder(Long id);


}
