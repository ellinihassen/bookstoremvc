package com.vermeg.bookstoremvc.model;

import com.vermeg.bookstoremvc.constant.OrderStateEnum;
import com.vermeg.bookstoremvc.dao.entity.Adresse;
import com.vermeg.bookstoremvc.dao.entity.OrderItem;
import com.vermeg.bookstoremvc.dao.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private static final Integer tva = 5;

    private Long id;
    private Date date;
    private OrderStateEnum status;
    private User user;
    private Adresse adresse;
    private List<OrderItemDTO> orderItems;
    private Double totalPrice;

    public OrderDTO(OrderStateEnum status, User user) {
        Date date = new Date();
        this.status = status;
        this.user = user;
        this.date = date;
    }

    public Double getTotalPrice() {
        for (OrderItemDTO orderItem : orderItems) {
            totalPrice += orderItem.getPrice();
        }
        return totalPrice;
    }
}
