package com.project.FlightJDBC.repository;

import com.project.FlightJDBC.entity.Role;
import com.project.FlightJDBC.entity.UserRole;
import com.project.FlightJDBC.entity.User;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pham Minh Luan
 * @email phamminhluan@fabercompany.co.jp
 */
@Repository
public class UserRoleRepository {

    @Autowired
    private HikariDataSource dataSource;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    public List<Role> findRoleByUserName(String userName) {
        String sql = "select\n"
                + "b.role_id as role_id,\n"
                + "role_name\n"
                + "from tbl_user_role c\n"
                + "join tbl_user a on a.user_id = c.user_id\n"
                + "join tbl_role b on b.role_id = c.role_id\n"
                + "where a.user_account = ?";
        List<Role> roles = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);) {
            statement.setString(1, userName);
            System.out.println("-----SQL WITH FLIGHT ID-----");
            System.out.println(statement.toString());
            try (ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    Role role = new Role();
                    role.setRoleId(rs.getInt("role_id"));
                    role.setRoleName(rs.getString("role_name"));
                    roles.add(role);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    public UserRole findUserRoleByUserName(String userName) {
        UserRole userRole = new UserRole();

        User user = userRepo.findByUserName(userName);
        if (user != null) {
            userRole.setUserId(user.getUserId());
            userRole.setUserAccount(user.getUserAccount());
            userRole.setActive(user.getActive());
            userRole.setUserPassword(user.getUserPassword());
            userRole.setRoles(findRoleByUserName(userName));
            return userRole;
        } else {
            System.out.println("User Null");
            return null;
        }
    }

    public Map<String, Object> checkLogin(String UserName, String password) {
        UserRole userRole = findUserRoleByUserName(UserName);
        Map result = new HashMap<>();
        result.put("status", "failed");
        result.put("userInfo", null);
        if (userRole != null) {
            result.put("userInfo", userRole);
            if (userRole.getActive() == 0) {
                result.put("status", "blocked");
            }
            if (!BCrypt.checkpw(password, userRole.getUserPassword())) {
                result.put("status", "wrong_password");
            }
            result.put("status", "success");
        }
        return result;
    }
}
