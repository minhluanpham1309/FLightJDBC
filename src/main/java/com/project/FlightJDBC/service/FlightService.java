package com.project.FlightJDBC.service;

//<editor-fold defaultstate="collapsed" desc="comment">
import com.project.FlightJDBC.DTO.FlightDTO;
import com.project.FlightJDBC.entity.Flight;
import java.util.List;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan <phamminhluan@fabercompany.co.jp>
 */
public interface FlightService {

    List<FlightDTO> findAll();

    List<FlightDTO> findByParam(FlightDTO flightDTO);

    FlightDTO findById(long id);

    int add(FlightDTO flight);

    boolean update(FlightDTO flight);

    boolean delete(long id);
}
