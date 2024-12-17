package com.codegym.service.impl;

import com.codegym.model.Order;
import com.codegym.repository.IOrderRepository;
import com.codegym.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOrderService{
    @Autowired
    private IOrderRepository orepo;
    @Override
    public Iterable<Order> findAll() {
        return orepo.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orepo.findById(id);
    }

    @Override
    public void save(Order order) {
        orepo.save(order);
    }

    @Override
    public void remove(Long id) {
       orepo.deleteById(id);
    }
}
