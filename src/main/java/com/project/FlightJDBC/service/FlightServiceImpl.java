package com.project.FlightJDBC.service;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.project.FlightJDBC.DTO.FlightDTO;
import com.project.FlightJDBC.entity.Flight;
import com.project.FlightJDBC.repository.FlightRepository;
import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan 
 * @email phamminhluan@fabercompany.co.jp 
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
    public List<Flight> findByParam(FlightDTO flightDTO) {

        Timestamp dateTimestamp = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
            Date date = formatter.parse(flightDTO.getDepartDate());
            dateTimestamp = new Timestamp(date.getTime());

        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return flightRepo.findByParams(flightDTO.getDepartAirportId(), flightDTO.getArrivAirportId(), flightDTO.getPriceFrom(), flightDTO.getPriceTo(), dateTimestamp);
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
