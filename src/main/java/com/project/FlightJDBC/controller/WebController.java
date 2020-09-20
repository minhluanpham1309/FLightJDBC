package com.project.FlightJDBC.controller;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.project.FlightJDBC.DTO.FlightDTO;
import com.project.FlightJDBC.service.AirportService;
import com.project.FlightJDBC.service.FlightService;
import com.project.FlightJDBC.service.OrderFlightService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan
 * @email phamminhluan@fabercompany.co.jp
 */
@Controller
public class WebController {

    @Autowired
    private FlightService flightserv;

    @Autowired
    private AirportService airportServ;

    @Autowired
    private OrderFlightService orderService;

//<editor-fold defaultstate="collapsed" desc="INDEX">
    @RequestMapping(value = "/index")
    public ModelAndView index(Model model) {

        Map<String, Object> map = new HashMap<>();
        map.put("flight", new FlightDTO());
        map.put("listAirport", airportServ.findAll());
        map.put("listFlight", flightserv.findAll());
        /*model.addAttribute("flight", new FlightDTO());
        model.addAttribute("listAirport", airportServ.findAll());
        model.addAttribute("listFlight", flightserv.findAll());*/
        return new ModelAndView("web/listFlight", map);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="SEARCH">
    @RequestMapping(value = "/searchFlight", method = RequestMethod.GET)
    public String searchFlight(@ModelAttribute(name = "flight") FlightDTO flight, Model model) {
        model.addAttribute("filght", new FlightDTO());
        
        model.addAttribute("listAirport", airportServ.findAll());
        model.addAttribute("listFlight", flightserv.findByParam(flight));
        return "web/listFlight";
    }
//</editor-fold>

}
