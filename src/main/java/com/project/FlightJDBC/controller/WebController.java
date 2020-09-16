package com.project.FlightJDBC.controller;
//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.project.FlightJDBC.service.FlightService;
import com.project.FlightJDBC.service.OrderFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//</editor-fold>


/**
 *
 * @author Pham Minh Luan <phamminhluan@fabercompany.co.jp>
 */
@Controller
public class WebController {
    @Autowired
    private FlightService flightserv;
    
    @Autowired
    private OrderFlightService orderService;
    //<editor-fold defaultstate="collapsed" desc="INDEX">
    @RequestMapping(value = "/")
    public String index(Model model){
        model.addAttribute("listFlight", flightserv.findAll());
        return "web/listFlight";
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="SEARCH">
    @RequestMapping(value = "/searchFlight", method = RequestMethod.GET)
    public String searchFlight(@RequestParam(value = "from")String from,
           @RequestParam(value = "to") String to, Model model){
        model.addAttribute("listFlight", flightserv.findByFromTo(from, to));
        return "web/listFlight";
    }
//</editor-fold>
    
}
