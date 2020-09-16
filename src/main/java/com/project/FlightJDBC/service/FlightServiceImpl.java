package com.project.FlightJDBC.service;

//<editor-fold defaultstate="collapsed" desc="comment">
import com.project.FlightJDBC.entity.Flight;
import com.project.FlightJDBC.repository.FlightRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan <phamminhluan@fabercompany.co.jp>
 */
@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepo;

//<editor-fold defaultstate="collapsed" desc="FIND ALL">
    @Override
    public List<Flight> findAll() {
        return flightRepo.findAll();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="FIND WITH PARAM">
    @Override
    public List<Flight> findByFromTo(String from, String to) {
        return flightRepo.findByParams(from, to);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="SAVE">
    @Override
    public Flight save(Flight flight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="UPDATE">
    @Override
    public Flight update(Flight flight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="DELETE">
    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="FIND BY ID">
    @Override
    public Flight findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//</editor-fold>

}
