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

    List<FlightDTO> findAll();

    List<FlightDTO> findByParams(String from, String to, int priceFrom, int priceTo, String date);

    int save(FlightDTO flight);

    boolean update(FlightDTO flight);

    boolean delete(long id);

    FlightDTO findById(long id);
    
}
