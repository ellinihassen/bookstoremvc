package com.vermeg.bookstoremvc.service.impl;

import com.vermeg.bookstoremvc.constant.OrderStateEnum;
import com.vermeg.bookstoremvc.dao.entity.Order;
import com.vermeg.bookstoremvc.dao.repository.OrderRepository;
import com.vermeg.bookstoremvc.model.OrderDTO;
import com.vermeg.bookstoremvc.service.OrderService;
import com.vermeg.bookstoremvc.service.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OrderServiceImpl extends GenericServiceImpl<Order> implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        super(orderRepository, orderMapper);
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }


    @Override
    @Transactional
    public OrderDTO update(OrderDTO order) {
        return orderMapper.mapToDto(
                orderRepository.update(orderMapper.mapToEntity(order))
                        .orElseThrow(() -> new EntityNotFoundException("Could not update Order"))
        );

    }

    @Override
    @Transactional
    public List<OrderDTO> getOrdersByUser(Long id) {
        return orderMapper.mapToDtoList(orderRepository.findByUserId(id));
    }

    @Override
    @Transactional
    public List<OrderDTO> getOrderByUserAndStatus(Long id, String status) {
        return orderMapper.mapToDtoList(orderRepository.findByUserIdAndStatus(id, status));
    }

    @Override
    @Transactional
    public OrderDTO validateOrder(OrderDTO order) {
        order.setStatus(OrderStateEnum.VALIDATED);
        return order;
    }
}
