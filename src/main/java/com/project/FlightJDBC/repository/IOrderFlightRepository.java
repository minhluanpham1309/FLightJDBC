/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.FlightJDBC.repository;

import com.project.FlightJDBC.entity.OrderFlight;
import java.util.List;

/**
 *
 * @author minhluan
 */
public interface IOrderFlightRepository {
    List<OrderFlight> findAll();
    Long save(OrderFlight orderFlight);
    void update(OrderFlight orderFlight);
    void delete(Long id);
    OrderFlight findById(Long id); 
}
