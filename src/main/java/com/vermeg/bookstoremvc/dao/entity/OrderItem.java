package com.vermeg.bookstoremvc.dao.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne()
    @JoinColumn(name = "book_id")
    private Book book;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Transient
    private Double price;

    public OrderItem(Book book, Integer quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public OrderItem(Book book) {
        this.book = book;
        this.quantity=1;
    }

    public Double getPrice() {
           price = book !=null ? book.getPrice() * quantity : 0;

        return price;
    }
}
