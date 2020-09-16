package com.project.FlightJDBC.repository;
//<editor-fold defaultstate="collapsed" desc="IMPORT">

import com.project.FlightJDBC.entity.Flight;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan <phamminhluan@fabercompany.co.jp>
 */
@Repository
public class FlightRepositoryImpl implements FlightRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource datasource;

//<editor-fold defaultstate="collapsed" desc="FINDALL">
    public List<Flight> findAll() {
        StringBuilder sqlBuilder = new StringBuilder(
                "select id, flight_number,\n"
                + "depart_airport_id,\n"
                + "a.airport_name as depart_airport_name,\n"
                + "arriv_airport_id,\n"
                + "b.airport_name as arriv_airport_name,\n"
                + "depart_date,arriv_date,price");
        sqlBuilder.append(" from Flight join tbl_airport a on Flight.depart_airport_id = a.airport_id\n");
        sqlBuilder.append(" join tbl_airport b on Flight.arriv_airport_id = b.airport_id\n");
        List<Flight> flights = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = datasource.getConnection();
            statement = conn.prepareStatement(sqlBuilder.toString());
            rs = statement.executeQuery();
            while (rs.next()) {
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

                flights.add(flight);
            }
            return flights;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            }
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="SET PARAM FOR STATEMENT">
    private void setParameters(PreparedStatement statement, Object... params) {
        try {
            for (int i = 0; i < params.length; i++) {
                Object parm = params[i];
                int index = i + 1;

                if (parm instanceof Long) {
                    statement.setLong(index, (Long) parm);
                } else if (parm instanceof String) {
                    statement.setString(index, (String) parm);
                } else if (parm instanceof Integer) {
                    statement.setInt(index, (int) parm);
                } else if (parm instanceof Timestamp) {
                    statement.setTimestamp(index, (Timestamp) parm);
                } else if (parm == null) {
                    statement.setNull(index, Types.NULL);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="FIND FLIGHT WITH PARAMETER">

    @Override
    public List<Flight> findByParams(Object... params) {
        StringBuilder sqlBuilder = new StringBuilder(
                "select id, flight_number,\n"
                + "depart_airport_id,\n"
                + "a.airport_name as depart_airport_name,\n"
                + "arriv_airport_id,\n"
                + "b.airport_name as arriv_airport_name,\n"
                + "depart_date,arriv_date,price\n");
        sqlBuilder.append(" from Flight join tbl_airport a on Flight.depart_airport_id = a.airport_id \n");
        sqlBuilder.append(" join tbl_airport b on Flight.arriv_airport_id = b.airport_id \n");
        sqlBuilder.append(" where depart_airport_id = ? and arriv_airport_id = ? \n");

        List<Flight> flights = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = datasource.getConnection();
            statement = conn.prepareStatement(sqlBuilder.toString());
            setParameters(statement, params);
            rs = statement.executeQuery();
            while (rs.next()) {
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

                flights.add(flight);
            }
            return flights;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            }
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="SAVE">
    @Override
    public Long save(Flight flight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="UPDATE">
    @Override
    public void update(Flight flight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="DELETE">
    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="FIND BY ID">
    @Override
    public Flight findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//</editor-fold>

}
