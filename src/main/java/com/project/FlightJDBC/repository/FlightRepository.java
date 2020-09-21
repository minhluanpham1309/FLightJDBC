package com.project.FlightJDBC.repository;

//<editor-fold defaultstate="collapsed" desc="comment">
import com.project.FlightJDBC.DTO.FlightDTO;
import com.project.FlightJDBC.entity.Flight;
import java.util.List;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan <phamminhluan@fabercompany.co.jp>
 */
public interface FlightRepository {

    List<Flight> findAll();

    List<Flight> findByParams(String from, String to, int priceFrom, int priceTo, String date);

    int save(FlightDTO flight);

    int update(FlightDTO flight);

    void delete(long id);

    Flight findById(long id);
    
}
