/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.FlightJDBC.service;

import com.project.FlightJDBC.entity.Flight;
import java.util.List;

/**
 *
 * @author minhluan
 */
public interface IFLightService {
    List<Flight> findAll();
    List<Flight> findByFromTo(String from, String to);
    Flight findById(Long id);
    Flight save(Flight flight);
    Flight update(Flight flight);
    void delete(Long id);
}
