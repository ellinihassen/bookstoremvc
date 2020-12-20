package com.vermeg.bookstoremvc.service.mapper.Impl;

import com.vermeg.bookstoremvc.dao.entity.OrderItem;
import com.vermeg.bookstoremvc.model.OrderItemDTO;
import com.vermeg.bookstoremvc.service.mapper.OrderItemMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapperImpl extends GenericMapperImpl<OrderItemDTO, OrderItem> implements OrderItemMapper {

    private final ModelMapper modelMapper;

    public OrderItemMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public OrderItemDTO mapToDto(OrderItem entity) {
       OrderItemDTO orderItemDTO = new OrderItemDTO();
       modelMapper.map(entity,orderItemDTO);
       return orderItemDTO;
    }

    @Override
    public OrderItem mapToEntity(OrderItemDTO dto) {
        OrderItem orderItem = new OrderItem();
        modelMapper.map(dto,orderItem);
        return orderItem;
    }
}
