package com.project.FlightJDBC.repository;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.project.FlightJDBC.entity.OrderFlight;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan <phamminhluan@fabercompany.co.jp>
 */
@Repository
public class OrderFlightRepositoryImpl implements OrderFlightRepository {

    @Autowired
    private HikariDataSource dataSource;

    //<editor-fold defaultstate="collapsed" desc="FIND ALL">
    @Override
    public List<OrderFlight> findAll() {
        String sql = "select  order_id,\n"
                + "flight_number,\n"
                + "depart_airport_id,\n"
                + "arriv_airport_id,\n"
                + "time_order,\n"
                + "type_order,\n"
                + "adult_number,\n"
                + "senior_number,\n"
                + "child_number,\n"
                + "total_price,\n"
                + "depart_date,\n"
                + "arriv_date,\n"
                + "price\n"
                + " from tbl_order_flight join tbl_flight on tbl_order_flight.flight_id = tbl_flight.flight_id";

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<OrderFlight> orders = new ArrayList<>();
        try {
            conn = dataSource.getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                OrderFlight orderFlight = new OrderFlight();

                orderFlight.setId(rs.getLong("order_id"));
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

                orders.add(orderFlight);
            }
            return orders;
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
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
                System.out.println(ex.getStackTrace());
                return null;
            }
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="SAVE">
    @Override
    public Long save(OrderFlight orderFlight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="UPDATE">
    @Override
    public void update(OrderFlight orderFlight) {
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
    public OrderFlight findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//</editor-fold>

}
