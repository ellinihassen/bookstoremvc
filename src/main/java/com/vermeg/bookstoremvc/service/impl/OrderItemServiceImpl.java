package com.vermeg.bookstoremvc.service.impl;

import com.vermeg.bookstoremvc.dao.entity.Book;
import com.vermeg.bookstoremvc.dao.entity.OrderItem;
import com.vermeg.bookstoremvc.dao.repository.OrderItemRepository;
import com.vermeg.bookstoremvc.service.OrderItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class OrderItemServiceImpl extends GenericServiceImpl<OrderItem> implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        super(orderItemRepository);
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderItem update(OrderItem orderItem) {
        return orderItemRepository.update(orderItem).orElseThrow(() -> new EntityNotFoundException("Could not update Book"));

    }

    @Override
    public List<OrderItem> getItemsByOrder(Long id) {
        return orderItemRepository.findAllByOrderId(id);
    }


}
