package com.vermeg.bookstoremvc.dao.repository.impl;

import com.vermeg.bookstoremvc.dao.entity.OrderItem;
import com.vermeg.bookstoremvc.dao.repository.OrderItemRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderItemRepositoryImpl extends GenericRepositoryImpl<OrderItem> implements OrderItemRepository {

    @Override
    public Optional<OrderItem> update(OrderItem orderItem) {
       Session currentSession = sessionFactory.getCurrentSession();
        findById(orderItem.getId()).orElseThrow(() -> new EntityNotFoundException("orderItem not found to update it"));
        currentSession.update(orderItem);
        return Optional.of(orderItem);
    }

    @Override
    public List<OrderItem> findAllByOrderId(Long id) {
       Session currentSession = sessionFactory.getCurrentSession();
        Query<OrderItem> theQuery =
                currentSession.createQuery("from orderitem where order_id:=orderId",
                        OrderItem.class);
        theQuery.setParameter("orderId", id);
        // execute query and get result list
        List<OrderItem> items = theQuery.getResultList();

        // return the results
        return items;
    }


}
