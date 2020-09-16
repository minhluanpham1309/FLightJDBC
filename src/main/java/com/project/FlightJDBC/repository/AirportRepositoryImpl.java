package com.project.FlightJDBC.repository;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.mysql.cj.protocol.Resultset;
import com.project.FlightJDBC.entity.Airport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan <phamminhluan@fabercompany.co.jp>
 */
@Repository
public class AirportRepositoryImpl implements AirportRepository {

    @Autowired
    private DataSource datasource;

    //<editor-fold defaultstate="collapsed" desc="FIND ALL">
    @Override
    public List<Airport> findAll() {
        List<Airport> airports = new ArrayList<>();
        String sql = "SELECT * FROM tbl_airport";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = datasource.getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Airport airport = new Airport();
                airport.setAirportId(rs.getString("airport_id"));
                airport.setAirportName(rs.getString("airport_name"));
                airports.add(airport);
            }
            return airports;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            }
        }
    }
//</editor-fold>

}
