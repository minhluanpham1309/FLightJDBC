/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.FlightJDBC.mapper;

import com.project.FlightJDBC.entity.Flight;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author minhluan
 */
public class FlightMapper implements RowsMapper<Flight> {

    @Override
    public Flight mapRow(ResultSet rs, int rowNum) {
        Flight flight = new Flight();
        try {
            flight.setId(rs.getLong("id"));
            flight.setDepartAirportId(rs.getString("depart_airport_id"));
            flight.setArrivAirportId(rs.getString("arriv_airport_id"));
            flight.setDepartDate(rs.getString("depart_date"));
            flight.setArrivDate(rs.getString("arriv_date"));
            flight.setPrice(rs.getInt("price"));
            flight.setDepartAirportName(rs.getString("depart_airport_name"));
            flight.setArrivAirportName(rs.getString("arriv_airport_name"));
            return flight;
        } catch (SQLException e) {
            return null;
        }
    }

}
