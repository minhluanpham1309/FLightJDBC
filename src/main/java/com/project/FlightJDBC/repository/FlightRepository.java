package com.project.FlightJDBC.repository;

import com.project.FlightJDBC.entity.Flight;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Pham Minh Luan <phamminhluan@fabercompany.co.jp>
 */
public interface FlightRepository {
    List<Flight> findAll();
    List<Flight> findByParams(String from, String to, int priceFrom, int priceTo, Timestamp date);
    Long save(Flight flight);
    void update(Flight flight);
    void delete(Long id);
    Flight findById(Long id); 
}
