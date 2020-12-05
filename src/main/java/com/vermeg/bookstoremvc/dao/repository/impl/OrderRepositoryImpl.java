package com.vermeg.bookstoremvc.dao.repository.impl;


import com.sun.org.apache.xpath.internal.operations.Or;
import com.vermeg.bookstoremvc.dao.entity.Order;
import com.vermeg.bookstoremvc.dao.repository.OrderRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepositoryImpl extends GenericRepositoryImpl<Order> implements OrderRepository {

    @Override
    public Optional<Order> update(Order order) {
        Session currentSession = sessionFactory.getCurrentSession();
        Order oldOrder = findById(order.getId()).orElseThrow(() -> new EntityNotFoundException("order not found to update it"));

        oldOrder.setStatus(order.getStatus());

        oldOrder.setAdresse(order.getAdresse());

        currentSession.update(oldOrder);
        return Optional.of(order);
    }

    @Override
    public List<Order> findByUserId(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Order> theQuery =
                currentSession.createQuery("from orders where user_id:=userId",
                        Order.class);
        theQuery.setParameter("userId", id);
        // execute query and get result list
        List<Order> orders = theQuery.getResultList();

        // return the results
        return orders;
    }

    @Override
    public List<Order> findByUserIdAndStatus(Long id, String status) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Order> theQuery =
                currentSession.createQuery("from orders where user_id:=userId and status:=stat",
                        Order.class);
        theQuery.setParameter("userId", id);
        theQuery.setParameter("stat", status);
        // execute query and get result list
        List<Order> orders = theQuery.getResultList();

        // return the results
        return orders;
    }
}
