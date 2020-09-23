package com.project.FlightJDBC.repository;

import com.project.FlightJDBC.entity.Role;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pham Minh Luan
 * @email phamminhluan@fabercompany.co.jp
 */
@Repository
public class RoleRepository {
    
    @Autowired 
    private HikariDataSource dataSource;
    
    public Role findById(long roleId){
         String sql = "select role_name,\n"
                + "where role_id = ?";
        Role role = null;
        try (Connection conn = dataSource.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);) {
            statement.setLong(1, roleId);
            System.out.println("-----SQL WITH FLIGHT ID-----");
            System.out.println(statement.toString());
            role = new Role();
            try (ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    
                    role.setRoleName(rs.getString("role_name"));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }
}
