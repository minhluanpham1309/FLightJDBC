package com.project.FlightJDBC.entity;

import java.io.Serializable;

/**
 *
 * @author Pham Minh Luan <phamminhluan@fabercompany.co.jp>
 */


public class Airport implements Serializable{
    private String airportId;
    private String airportName;

//<editor-fold defaultstate="collapsed" desc="GET SET">
    public String getAirportId() {
        return airportId;
    }

    public void setAirportId(String airportId) {
        this.airportId = airportId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
//</editor-fold>
    
}
