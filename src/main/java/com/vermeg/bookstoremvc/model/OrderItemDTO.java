package com.vermeg.bookstoremvc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vermeg.bookstoremvc.dao.entity.Book;
import com.vermeg.bookstoremvc.dao.entity.Order;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {

    private Long id;
    private BookDTO book;
    private Integer quantity;
    @JsonIgnore
    private OrderDTO order;
    private Double price;

    public OrderItemDTO(BookDTO book) {
        this.book = book;
        this.quantity=1;
    }

    public Double getPrice() {
        price = book !=null ? book.getPrice() * quantity : 0;

        return price;
    }

}
