package com.project.FlightJDBC.entity;

//<editor-fold defaultstate="collapsed" desc="comment">
import java.sql.Timestamp;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan <phamminhluan@fabercompany.co.jp>
 */
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

//<editor-fold defaultstate="collapsed" desc="comment">
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(Timestamp timeOrder) {
        this.timeOrder = timeOrder;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getAdultNumber() {
        return adultNumber;
    }

    public void setAdultNumber(int adultNumber) {
        this.adultNumber = adultNumber;
    }

    public int getSeniorNumber() {
        return seniorNumber;
    }

    public void setSeniorNumber(int seniorNumber) {
        this.seniorNumber = seniorNumber;
    }

    public int getChildNumber() {
        return childNumber;
    }

    public void setChildNumber(int childNumber) {
        this.childNumber = childNumber;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTypeOrder() {
        return typeOrder;
    }

    public void setTypeOrder(String typeOrder) {
        this.typeOrder = typeOrder;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
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
