package com.project.FlightJDBC.service;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.project.FlightJDBC.entity.Airport;
import java.util.List;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan, <phamminhluan@fabercompany.co.jp>
 */
public interface AirportService {

    List<Airport> findAll();
}
