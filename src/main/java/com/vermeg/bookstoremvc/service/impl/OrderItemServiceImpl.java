package com.vermeg.bookstoremvc.service.impl;

import com.vermeg.bookstoremvc.dao.entity.OrderItem;
import com.vermeg.bookstoremvc.dao.repository.OrderItemRepository;
import com.vermeg.bookstoremvc.model.OrderItemDTO;
import com.vermeg.bookstoremvc.service.OrderItemService;
import com.vermeg.bookstoremvc.service.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class OrderItemServiceImpl extends GenericServiceImpl<OrderItem> implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, OrderItemMapper orderItemMapper) {
        super(orderItemRepository, orderItemMapper);
        this.orderItemRepository = orderItemRepository;
        this.orderItemMapper = orderItemMapper;
    }

    @Override
    @Transactional
    public OrderItemDTO update(OrderItemDTO orderItem) {
        return orderItemMapper.mapToDto(
                orderItemRepository.update(orderItemMapper.mapToEntity(orderItem)).
                        orElseThrow(() -> new EntityNotFoundException("Could not update Book"))
        );

    }

    @Override
    @Transactional
    public List<OrderItemDTO> getItemsByOrder(Long id) {
        return orderItemMapper.mapToDtoList(orderItemRepository.findAllByOrderId(id));
    }


}
