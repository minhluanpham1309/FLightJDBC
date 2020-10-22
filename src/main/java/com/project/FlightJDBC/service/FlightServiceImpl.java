package com.project.FlightJDBC.service;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.project.FlightJDBC.DTO.FlightDTO;
import com.project.FlightJDBC.entity.Flight;
import com.project.FlightJDBC.repository.FlightRepository;
import com.project.FlightJDBC.repository.OrderFlightRepository;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan 
 * @email phamminhluan@fabercompany.co.jp 
 */
@Service
public class FlightServiceImpl implements FlightService {
    
    private static final Logger logger = LogManager.getLogger(FlightServiceImpl.class);
    
    @Autowired
    private FlightRepository flightRepo;

    @Autowired 
    private OrderFlightRepository orderFlightRepo;
    
    
    //<editor-fold defaultstate="collapsed" desc="FIND ALL">
    
    @Override
    //@Cacheable(value = "flights")
    public List<FlightDTO> findAll() {
        List<FlightDTO> flights = flightRepo.findAll();
        return flights;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="FIND WITH PARAM">
    @Override
    //@Cacheable(value = "flights", key = "{#flightDTO.departAirportId, #flightDTO.arrivAirportId}", unless = "#result!=null")
    public List<FlightDTO> findByParam(FlightDTO flightDTO) {
        List<FlightDTO> flights = flightRepo.findByParams( flightDTO.getDepartAirportId(), 
                                        flightDTO.getArrivAirportId(), 
                                        flightDTO.getPriceFrom(), 
                                        flightDTO.getPriceTo(), 
                                        flightDTO.getDepartDate());
        return flights;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="SAVE">
    @Override
    //@CacheEvict(value = "flights", allEntries = true )
    public int add(FlightDTO flight) {
        return flightRepo.save(flight);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="UPDATE">
    @Override
    //@CacheEvict(value = "flights", allEntries = true)
    public boolean update(FlightDTO flight) {
        return flightRepo.update(flight);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="DELETE">
    @Override
    //@CacheEvict(value = "flights", allEntries = true)
    public boolean delete(long id) {
        if(orderFlightRepo.countOrderForFlightId(id)>0){
            return false;
        }else{
            return flightRepo.delete(id);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="FIND BY ID">
    @Override
    //@Cacheable("flight")
    public FlightDTO findById(long id) {
        return flightRepo.findById(id);
    }
    //</editor-fold>

    

}
