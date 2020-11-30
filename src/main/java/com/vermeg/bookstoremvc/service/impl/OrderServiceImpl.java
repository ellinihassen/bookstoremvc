package com.vermeg.bookstoremvc.service.impl;

import com.vermeg.bookstoremvc.constant.OrderStateEnum;
import com.vermeg.bookstoremvc.dao.entity.Order;
import com.vermeg.bookstoremvc.dao.repository.OrderRepository;
import com.vermeg.bookstoremvc.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl extends GenericServiceImpl<Order> implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        super(orderRepository);
        this.orderRepository = orderRepository;
    }


    @Override
    public Order update(Order order) {
        return orderRepository.update(order).orElseThrow(() -> new EntityNotFoundException("Could not update Order"));

    }

    @Override
    public List<Order> getOrdersByUser(Long id) {
        return orderRepository.findByUserId(id);
    }

    @Override
    public List<Order> getOrderByUserAndStatus(Long id, String status) {
        return orderRepository.findByUserIdAndStatus(id,status);
    }

    @Override
    public Order validateOrder(Order order) {
        order.setStatus(OrderStateEnum.VALIDATED);
        return order;
    }
}
