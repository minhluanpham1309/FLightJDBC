package com.project.FlightJDBC.repository;

import com.project.FlightJDBC.entity.User;
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
public class UserRepository {

    @Autowired
    private HikariDataSource dataSource;

    public User findByUserName(String userName) {
        String sql = "select user_id,\n"
                + "user_account,\n"
                + "user_password,\n"
                + "user_active\n"
                + "from tbl_user\n"
                + "where user_account = ?";
        User user = null;
        try (Connection conn = dataSource.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);) {
            statement.setString(1, userName);
            System.out.println("-----SQL WITH FLIGHT ID-----");
            System.out.println(statement.toString());
            user = new User();
            try (ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    user.setUserId(rs.getLong("user_id"));
                    user.setUserAccount(rs.getString("user_account"));
                    user.setUserPassword(rs.getString("user_password"));
                    user.setActive(rs.getInt("user_active"));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
