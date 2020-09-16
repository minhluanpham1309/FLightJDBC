/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.FlightJDBC.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author minhluan
 */
@Data
public class OrderFlight {
    private Long id;
    private Timestamp timeOrder;
    private String flightNumber;
    private int adultNumber;
    private int seniorNumber;
    private int childNumber;
    private int totalPrice;
    private String typeOrder;
    private String flightId;
    private String departDate;
    private String arrivDate;
    private int price;
    private String departAirportId;
    private String arrivAirportId;
    private String departAirportName;
    private String arrivAirportName;
    
}
