package com.codegym.service.impl;

import com.codegym.model.OrderDetail;
import com.codegym.repository.IOrderDetailRepository;
import com.codegym.service.IOrderDetailService;
import com.codegym.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    private IOrderDetailRepository drepo;
    @Override
    public Iterable<OrderDetail> findAll() {
        return drepo.findAll();
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
       return drepo.findById(id);
    }

    @Override
    public void save(OrderDetail orderDetail) {
        drepo.save(orderDetail);
    }

    @Override
    public void remove(Long id) {
        drepo.deleteById(id);
    }
}
