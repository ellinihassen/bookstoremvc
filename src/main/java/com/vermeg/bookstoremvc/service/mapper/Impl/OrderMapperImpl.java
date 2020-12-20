package com.vermeg.bookstoremvc.service.mapper.Impl;

import com.vermeg.bookstoremvc.dao.entity.Order;
import com.vermeg.bookstoremvc.model.OrderDTO;
import com.vermeg.bookstoremvc.service.mapper.OrderMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperImpl extends GenericMapperImpl<OrderDTO, Order> implements OrderMapper {
    private final ModelMapper modelMapper;

    public OrderMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public OrderDTO mapToDto(Order entity) {
        OrderDTO orderDTO = new OrderDTO();
        modelMapper.map(entity, orderDTO);
        return orderDTO;
    }

    @Override
    public Order mapToEntity(OrderDTO dto) {
        Order order = new Order();
        modelMapper.map(dto, order);
        return order;
    }
}
