package com.project.FlightJDBC.service;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.project.FlightJDBC.DTO.FlightDTO;
import com.project.FlightJDBC.entity.Flight;
import com.project.FlightJDBC.repository.FlightRepository;
import com.project.FlightJDBC.repository.OrderFlightRepository;
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

    @Autowired 
    private OrderFlightRepository orderFlightRepo;
//<editor-fold defaultstate="collapsed" desc="FIND ALL">
    @Override
    public List<Flight> findAll() {
        return flightRepo.findAll();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="FIND WITH PARAM">
    @Override
    public List<Flight> findByParam(FlightDTO flightDTO) {

        return flightRepo.findByParams( flightDTO.getDepartAirportId(), 
                                        flightDTO.getArrivAirportId(), 
                                        flightDTO.getPriceFrom(), 
                                        flightDTO.getPriceTo(), 
                                        flightDTO.getDepartDate());
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="SAVE">
    @Override
    public int save(FlightDTO flight) {
        return flightRepo.save(flight);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="UPDATE">
    @Override
    public int update(FlightDTO flight) {
        return flightRepo.update(flight);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="DELETE">
    @Override
    public void delete(long id) {
        int orderCounting = orderFlightRepo.countOrderForFlightId(id);
        if(orderCounting > 0){
            System.out.println("Not delete flight because order that related with table flight by id, had data");
        }else{
            flightRepo.delete(id);
        }
        
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="FIND BY ID">
    @Override
    public Flight findById(long id) {
        return flightRepo.findById(id);
    }
//</editor-fold>

}
