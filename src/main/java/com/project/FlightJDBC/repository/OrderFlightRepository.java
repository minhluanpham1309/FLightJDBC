package com.project.FlightJDBC.repository;

import com.project.FlightJDBC.entity.OrderFlight;
import java.util.List;

/**
 *
 * @author Pham Minh Luan <phamminhluan@fabercompany.co.jp>
 */
public interface OrderFlightRepository {
    List<OrderFlight> findAll();
    Long save(OrderFlight orderFlight);
    void update(OrderFlight orderFlight);
    void delete(Long id);
    OrderFlight findById(Long id); 
}
