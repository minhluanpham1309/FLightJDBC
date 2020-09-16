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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author minhluan
 */
@Controller
public class webController {
    @Autowired
    private FlightService flightserv;
    
    @Autowired
    private OrderFlightService orderService;
    
    @RequestMapping(value = "/")
    public String index(Model model){
        model.addAttribute("listFlight", flightserv.findAll());
        return "web/listFlight";
    }
    @RequestMapping(value = "/searchFlight", method = RequestMethod.GET)
    public String searchFlight(@RequestParam(value = "from")String from,
           @RequestParam(value = "to") String to, Model model){
        model.addAttribute("listFlight", flightserv.findByFromTo(from, to));
        return "web/listFlight";
    }
}
