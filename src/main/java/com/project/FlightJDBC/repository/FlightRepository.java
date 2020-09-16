package com.project.FlightJDBC.repository;

import com.project.FlightJDBC.entity.Flight;
import java.util.List;

/**
 *
 * @author Pham Minh Luan <phamminhluan@fabercompany.co.jp>
 */
public interface FlightRepository {
    List<Flight> findAll();
    List<Flight> findByParams(Object... params);
    Long save(Flight flight);
    void update(Flight flight);
    void delete(Long id);
    Flight findById(Long id); 
}
