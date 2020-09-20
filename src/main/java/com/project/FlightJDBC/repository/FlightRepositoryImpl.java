package com.project.FlightJDBC.repository;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.project.FlightJDBC.entity.Flight;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan <phamminhluan@fabercompany.co.jp>
 */
@Repository
public class FlightRepositoryImpl implements FlightRepository {

    @Autowired
    private HikariDataSource datasource;

//<editor-fold defaultstate="collapsed" desc="FINDALL">
    @Override
    public List<Flight> findAll() {
        String sql = "select flight_id, flight_number,\n"
                + "depart_airport_id,\n"
                + "a.airport_name as depart_airport_name,\n"
                + "arriv_airport_id,\n"
                + "b.airport_name as arriv_airport_name,\n"
                + "depart_date,\n"
                + "arriv_date,\n"
                + "price\n"
                + "from tbl_flight join tbl_airport a on tbl_flight.depart_airport_id = a.airport_id \n"
                + "join tbl_airport b on tbl_flight.arriv_airport_id = b.airport_id \n";
        List<Flight> flights = new ArrayList<>();

        try (Connection conn = datasource.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                Flight flight = new Flight();

                flight.setId(rs.getLong("flight_id"));
                flight.setFlightNumber(rs.getString("flight_number"));
                flight.setDepartAirportId(rs.getString("depart_airport_id"));
                flight.setArrivAirportId(rs.getString("arriv_airport_id"));
                flight.setDepartDate(rs.getTimestamp("depart_date"));
                flight.setArrivDate(rs.getTimestamp("arriv_date"));
                flight.setPrice(rs.getInt("price"));
                flight.setDepartAirportName(rs.getString("depart_airport_name"));
                flight.setArrivAirportName(rs.getString("arriv_airport_name"));

                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
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
    public List<Flight> findByParams(String from, String to, int priceFrom, int priceTo, Timestamp date) {

        List<Flight> flights = new ArrayList<>();
        String sql = "select flight_id, flight_number,\n"
                + "depart_airport_id,\n"
                + "a.airport_name as depart_airport_name,\n"
                + "arriv_airport_id,\n"
                + "b.airport_name as arriv_airport_name,\n"
                + "depart_date,\n"
                + "arriv_date,\n"
                + "price\n"
                + "from tbl_flight join tbl_airport a on tbl_flight.depart_airport_id = a.airport_id \n"
                + "join tbl_airport b on tbl_flight.arriv_airport_id = b.airport_id \n"
                + "where 1=1\n";
        
        if (!from.isEmpty() && !to.isEmpty()) {
            sql = sql.concat("and if(1=1\n");
        } else {
            sql = sql.concat("and if(1=0\n");
        }
        sql = sql.concat(",depart_airport_id = ? and arriv_airport_id = ?, 1=1)\n");

        if (!(priceTo == 0)) {
            sql = sql.concat("and if(1=1\n"); 
        }else{
            sql = sql.concat("and if(1=0\n");
        }
        sql = sql.concat(",price between ? and ?,1=1)\n");
        
        try (Connection conn = datasource.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);) {
            statement.setString(1, from);
            statement.setString(2, to);
            statement.setInt(3, priceFrom);
            statement.setInt(4, priceTo);
            System.out.println("---sql---");
            System.out.println(statement.toString());
            try (ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    Flight flight = new Flight();

                    flight.setId(rs.getLong("flight_id"));
                    flight.setFlightNumber(rs.getString("flight_number"));
                    flight.setDepartAirportId(rs.getString("depart_airport_id"));
                    flight.setArrivAirportId(rs.getString("arriv_airport_id"));
                    flight.setDepartDate(rs.getTimestamp("depart_date"));
                    flight.setArrivDate(rs.getTimestamp("arriv_date"));
                    flight.setPrice(rs.getInt("price"));
                    flight.setDepartAirportName(rs.getString("depart_airport_name"));
                    flight.setArrivAirportName(rs.getString("arriv_airport_name"));

                    flights.add(flight);
                }
            }
            return flights;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
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
