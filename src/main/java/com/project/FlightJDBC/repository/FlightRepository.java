/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.FlightJDBC.repository;

import com.project.FlightJDBC.entity.Flight;
import com.project.FlightJDBC.mapper.FlightMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.project.FlightJDBC.mapper.RowsMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author minhluan
 */
@Repository
public class FlightRepository implements IFlightRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Flight> findAll() {
        StringBuilder sqlBuilder = new StringBuilder(
                "select id, flight_number,"
                + "depart_airport_id,"
                + "a.airport_name as depart_airport_name,"
                + "arriv_airport_id,"
                + "b.airport_name as arriv_airport_name,"
                + "depart_date,arriv_date,price");
        sqlBuilder.append(" from Flight join tbl_airport a on Flight.depart_airport_id = a.airport_id");
        sqlBuilder.append(" join tbl_airport b on Flight.arriv_airport_id = b.airport_id");
        
        List<Flight> result = jdbcTemplate.query(sqlBuilder.toString(), new RowMapper<Flight>() {
            @Override
            public Flight mapRow(ResultSet rs, int i) throws SQLException {
                Flight flight = new Flight();

                flight.setId(rs.getLong("id"));
                flight.setFlightNumber(rs.getString("flight_number"));
                flight.setDepartAirportId(rs.getString("depart_airport_id"));
                flight.setArrivAirportId(rs.getString("arriv_airport_id"));
                flight.setDepartDate(rs.getString("depart_date"));
                flight.setArrivDate(rs.getString("arriv_date"));
                flight.setPrice(rs.getInt("price"));
                flight.setDepartAirportName(rs.getString("depart_airport_name"));
                flight.setArrivAirportName(rs.getString("arriv_airport_name"));
                return flight;
            }
        });
        return result;
    }

    @Override
    public List<Flight> findByFromTo(String from, String to) {
        StringBuilder sqlBuilder = new StringBuilder(
                "select id, flight_number,"
                + "depart_airport_id,"
                + "a.airport_name as depart_airport_name,"
                + "arriv_airport_id,"
                + "b.airport_name as arriv_airport_name,"
                + "depart_date,arriv_date,price");
        sqlBuilder.append(" from Flight join tbl_airport a on Flight.depart_airport_id = a.airport_id");
        sqlBuilder.append(" join tbl_airport b on Flight.arriv_airport_id = b.airport_id");
        sqlBuilder.append(" where depart_airport_id = ? and arriv_airport_id = ?");
        
        List<Flight> result = jdbcTemplate.query(sqlBuilder.toString(),new Object[]{from, to}, new RowMapper<Flight>() {
            @Override
            public Flight mapRow(ResultSet rs, int i) throws SQLException {
                Flight flight = new Flight();

                flight.setId(rs.getLong("id"));
                flight.setFlightNumber(rs.getString("flight_number"));
                flight.setDepartAirportId(rs.getString("depart_airport_id"));
                flight.setArrivAirportId(rs.getString("arriv_airport_id"));
                flight.setDepartDate(rs.getString("depart_date"));
                flight.setArrivDate(rs.getString("arriv_date"));
                flight.setPrice(rs.getInt("price"));
                flight.setDepartAirportName(rs.getString("depart_airport_name"));
                flight.setArrivAirportName(rs.getString("arriv_airport_name"));
                return flight;
            }
        });
        return result;
    }

    @Override
    public Long save(Flight flight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Flight flight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Flight findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
