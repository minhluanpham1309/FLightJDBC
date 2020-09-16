/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.FlightJDBC.entity;


import lombok.Data;

/**
 *
 * @author minhluan
 */
@Data
public class Flight {
   
    private Long id;
    private String flightNumber;
    private String departDate;
    private String arrivDate;
    private int price;
    private String departAirportId;
    private String arrivAirportId;
    private String departAirportName;
    private String arrivAirportName;
}
