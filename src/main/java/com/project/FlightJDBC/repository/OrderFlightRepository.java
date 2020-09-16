/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.FlightJDBC.repository;

import com.project.FlightJDBC.entity.OrderFlight;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author minhluan
 */
@Repository
public class OrderFlightRepository implements IOrderFlightRepository{

    @Autowired
    private JdbcTemplate jdbctemplate;
    @Override
    public List<OrderFlight> findAll() {
        String sql = "select  order_flight.id as orderId, "
                            + "flight_number, "
                            + "depart_airport_id, "
                            + "arriv_airport_id,"
                            + "time_order,"
                            + "type_order,"
                            + "adult_number,"
                            + "senior_number,"
                            + "child_number, "
                            + "total_price," 
                            + "depart_date,"
                            + "arriv_date,"
                            + "price"
                            + " from order_flight join Flight on order_flight.flight_id = flight.id";
        List<OrderFlight> orderFlights = jdbctemplate.query(sql, new RowMapper<OrderFlight>() {
            @Override
            public OrderFlight mapRow(ResultSet rs, int i) throws SQLException {
                OrderFlight orderFlight = new OrderFlight();
                orderFlight.setId(rs.getLong("orderId"));
                orderFlight.setFlightNumber(rs.getString("flight_number"));
                orderFlight.setTypeOrder(rs.getString("type_order"));
                orderFlight.setAdultNumber(rs.getInt("adult_number"));
                orderFlight.setSeniorNumber(rs.getInt("senior_number"));
                orderFlight.setChildNumber(rs.getInt("child_number"));
                orderFlight.setTimeOrder(rs.getTimestamp("time_order"));
                orderFlight.setDepartAirportId(rs.getString("depart_airport_id"));
                orderFlight.setArrivAirportId(rs.getString("arriv_airport_id"));
                orderFlight.setDepartDate(rs.getString("depart_date"));
                orderFlight.setArrivDate(rs.getString("arriv_date"));
                orderFlight.setPrice(rs.getInt("price"));
                orderFlight.setTotalPrice(rs.getInt("total_price"));
                return orderFlight;
            }
        });
        return orderFlights;
    }

    @Override
    public Long save(OrderFlight orderFlight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(OrderFlight orderFlight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderFlight findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
