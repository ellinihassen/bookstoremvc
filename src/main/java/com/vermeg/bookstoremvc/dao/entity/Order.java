package com.vermeg.bookstoremvc.dao.entity;


import com.vermeg.bookstoremvc.constant.OrderStateEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;

    @Enumerated(EnumType.STRING)
    private OrderStateEnum status;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    @OneToMany(mappedBy = "order",cascade = CascadeType.PERSIST)
    private List<OrderItem> orderItems;

    private static final Integer tva = 5;


    public Order(OrderStateEnum status, User user) {
        Date date = new Date();
        this.status = status;
        this.user = user;
        this.date = date;
    }


}
