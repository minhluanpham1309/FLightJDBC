/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.FlightJDBC.controller;

import com.project.FlightJDBC.service.FlightService;
import com.project.FlightJDBC.service.OrderFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author minhluan
 */
@Controller
public class adminController {
    
    @Autowired
    private FlightService flightserv;
    
    @Autowired
    private OrderFlightService orderService;
    
    @RequestMapping(value = "/admin")
    public String index(){
        return "admin/wellcome";
    }
    
    @RequestMapping(value = "/admin/listflight")
    public String listFlight(Model model){
        model.addAttribute("listFlight", flightserv.findAll());
        return "admin/listFlight";
    }
    
    @RequestMapping(value = "/admin/listorder")
    public String listOrder(Model model){
        model.addAttribute("listOrder", orderService.findAll());
        return "admin/listOrder";
    }
}
