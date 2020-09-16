/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.FlightJDBC.service;

import com.project.FlightJDBC.entity.OrderFlight;
import java.util.List;

/**
 *
 * @author minhluan
 */
public interface IOrderFlightService {
    List<OrderFlight> findAll();
    OrderFlight findById(Long id);
    OrderFlight save(OrderFlight flight);
    OrderFlight update(OrderFlight flight);
    void delete(Long id);
}
