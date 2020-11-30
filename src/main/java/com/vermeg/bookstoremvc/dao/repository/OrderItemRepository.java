package com.vermeg.bookstoremvc.dao.repository;

import com.vermeg.bookstoremvc.dao.entity.OrderItem;


import java.util.List;
import java.util.Optional;


public interface OrderItemRepository extends GenericRepository<OrderItem> {

    public Optional<OrderItem> update(OrderItem orderItem);
    public List<OrderItem> findAllByOrderId(Long id);






}
