package com.project.FlightJDBC.entity;

/**
 *
 * @author Pham Minh Luan <phamminhluan@fabercompany.co.jp>
 */
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
    //private String flightType;

 //<editor-fold defaultstate="collapsed" desc="Get Set">
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getArrivDate() {
        return arrivDate;
    }

    public void setArrivDate(String arrivDate) {
        this.arrivDate = arrivDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDepartAirportId() {
        return departAirportId;
    }

    public void setDepartAirportId(String departAirportId) {
        this.departAirportId = departAirportId;
    }

    public String getArrivAirportId() {
        return arrivAirportId;
    }

    public void setArrivAirportId(String arrivAirportId) {
        this.arrivAirportId = arrivAirportId;
    }

    public String getDepartAirportName() {
        return departAirportName;
    }

    public void setDepartAirportName(String departAirportName) {
        this.departAirportName = departAirportName;
    }

    public String getArrivAirportName() {
        return arrivAirportName;
    }

    public void setArrivAirportName(String arrivAirportName) {
        this.arrivAirportName = arrivAirportName;
    }
//</editor-fold>
   

}
