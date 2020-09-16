/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.FlightJDBC.repository;

import com.project.FlightJDBC.entity.Flight;
import java.util.List;

/**
 *
 * @author minhluan
 */
public interface IFlightRepository {
    List<Flight> findAll();
    List<Flight> findByFromTo(String from, String to);
    Long save(Flight flight);
    void update(Flight flight);
    void delete(Long id);
    Flight findById(Long id); 
}
