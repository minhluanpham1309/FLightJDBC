package com.project.FlightJDBC.service;

//<editor-fold defaultstate="collapsed" desc="comment">
import com.project.FlightJDBC.entity.Flight;
import java.util.List;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan <phamminhluan@fabercompany.co.jp>
 */
public interface FlightService {

    List<Flight> findAll();

    List<Flight> findByFromTo(String from, String to);

    Flight findById(Long id);

    Flight save(Flight flight);

    Flight update(Flight flight);

    void delete(Long id);
}
