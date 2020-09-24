package com.project.FlightJDBC.service;

//<editor-fold defaultstate="collapsed" desc="comment">
import com.project.FlightJDBC.entity.Airport;
import com.project.FlightJDBC.repository.AirportRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan <phamminhluan@fabercompany.co.jp>
 */
@Service
public class AirportServiceImpl implements AirportService {
    
    @Autowired
    private AirportRepository airportRepo;

    @Override
    public List<Airport> findAll() {
        return airportRepo.findAll();
    }
    
}
