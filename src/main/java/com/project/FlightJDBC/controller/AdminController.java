package com.project.FlightJDBC.controller;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.project.FlightJDBC.DTO.FlightDTO;
import com.project.FlightJDBC.entity.Flight;
import com.project.FlightJDBC.service.AirportService;
import com.project.FlightJDBC.service.FlightService;
import com.project.FlightJDBC.service.OrderFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan
 * @email phamminhluan@fabercompany.co.jp
 */
@Controller
public class AdminController {

    @Autowired
    private AirportService airportServ;

    @Autowired
    private FlightService flightserv;

    @Autowired
    private OrderFlightService orderService;

//<editor-fold defaultstate="collapsed" desc="WELLCOME">
    @RequestMapping(value = "/admin")
    public String index() {
        return "admin/wellcome";
    }
    //</editor-fold>

//<editor-fold defaultstate="collapsed" desc="LIST FLIGHT">
    @RequestMapping(value = "/admin/listflight")
    public String listFlight(Model model) {
        model.addAttribute("listFlight", flightserv.findAll());
        return "admin/listFlight";
    }
    //</editor-fold>

//<editor-fold defaultstate="collapsed" desc="LIST ORDER">
    @RequestMapping(value = "/admin/listorder")
    public String listOrder(Model model) {
        model.addAttribute("listOrder", orderService.findAll());
        return "admin/listOrder";
    }
    //</editor-fold>

//<editor-fold defaultstate="collapsed" desc="OPEN DETAIL FLIGHT">
    @RequestMapping(value = "admin/addFlight", method = RequestMethod.GET)
    public String openDetailFlight(Model model) {
        model.addAttribute("listAirport", airportServ.findAll());
        model.addAttribute("flight", new FlightDTO());
        return "admin/detailFlight";
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="ADD FLIGHT">
    @RequestMapping(value = "admin/addFlight", method = RequestMethod.POST)
    public String addFlight(@ModelAttribute FlightDTO flight, Model model) {
        if (flight.getId() == null) {
            if (flightserv.save(flight) > 0) {
                System.out.println("---ADD SUCCESS---");
            } else {
                System.out.println("----ADD NOT SUCCESS----");
            }
        } else {
            flightserv.update(flight);
        }
        return "redirect:/admin/listflight";
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="UPDATE FLIGHT">
    @RequestMapping(value = "admin/edit/{id}", method = RequestMethod.GET)
    public String updateFlight(@PathVariable("id") Long id, Model model) {
        Flight flight = flightserv.findById(id);
        model.addAttribute("listAirport", airportServ.findAll());
        model.addAttribute("flight", flight);
        return "admin/detailFlight";
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="DELETE FLIGHT">
    @RequestMapping(value = "admin/delete/{id}", method = RequestMethod.POST)
    public String deleteFlight(@PathVariable("id") long id, Model model) {

        return "redirect:/admin/listflight";
    }
//</editor-fold>
}
