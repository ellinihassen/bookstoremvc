package com.vermeg.bookstoremvc.dao.repository;

import com.vermeg.bookstoremvc.dao.entity.Order;


import java.util.List;
import java.util.Optional;


public interface OrderRepository extends GenericRepository<Order> {

    public Optional<Order> update(Order order);
    public List<Order> findByUserId(Long id);

    public List<Order> findByUserIdAndStatus(Long id, String status);


}
