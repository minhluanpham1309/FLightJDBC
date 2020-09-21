/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.FlightJDBC.service;

import com.project.FlightJDBC.entity.OrderFlight;
import com.project.FlightJDBC.repository.OrderFlightRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author minhluan
 */
@Service
public class OrderFlightServiceImpl implements OrderFlightService{
    
    @Autowired
    private OrderFlightRepository orderFlightRepo;

    @Override
    public List<OrderFlight> findAll() {
        return orderFlightRepo.findAll();
    }

    @Override
    public OrderFlight findById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderFlight save(OrderFlight flight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderFlight update(OrderFlight flight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
