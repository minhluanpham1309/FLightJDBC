package com.project.FlightJDBC.controller;

//<editor-fold defaultstate="collapsed" desc="comment">
import com.project.FlightJDBC.service.FlightService;
import com.project.FlightJDBC.service.OrderFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan <phamminhluan@fabercompany.co.jp>
 */
@Controller
public class AdminController {

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

}
