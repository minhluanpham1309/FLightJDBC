package com.project.FlightJDBC.service;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.project.FlightJDBC.entity.OrderFlight;
import java.util.List;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan <phamminhluan@fabercompany.co.jp>
 */
public interface OrderFlightService {

    List<OrderFlight> findAll();

    OrderFlight findById(Long id);

    OrderFlight save(OrderFlight flight);

    OrderFlight update(OrderFlight flight);

    void delete(Long id);
}
