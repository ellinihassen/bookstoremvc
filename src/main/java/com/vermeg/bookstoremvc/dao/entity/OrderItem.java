package com.vermeg.bookstoremvc.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem implements Serializable {
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

    public OrderItem(Book book, Integer quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public OrderItem(Book book) {
        this.book = book;
        this.quantity=1;
    }

    public Double calaculateTotalPrice() {
        return book.getPrice() * quantity;
    }
}
