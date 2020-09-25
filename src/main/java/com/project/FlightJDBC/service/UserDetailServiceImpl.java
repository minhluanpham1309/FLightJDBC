package com.project.FlightJDBC.service;

import com.project.FlightJDBC.entity.Role;
import com.project.FlightJDBC.entity.UserRole;
import com.project.FlightJDBC.repository.UserRoleRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Pham Minh Luan
 * @email phamminhluan@fabercompany.co.jp
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRoleRepository userRoleRepo;

    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserRole userRole = userRoleRepo.findUserRoleByUserName(userName);
        if (userRole == null) {
            throw new UsernameNotFoundException("User not found");
        }
        Set<GrantedAuthority> grantedAuthor = new HashSet<>();
        List<Role> roles = userRole.getRoles();
        for (Role role : roles) {
            grantedAuthor.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return new User(userRole.getUserAccount(), userRole.getUserPassword(), grantedAuthor);
    }

    public String checkLogin(String userName, String password, HttpServletRequest request) {
        Map<String, Object> result = userRoleRepo.checkLogin(userName, password);
        if ((result.get("status").toString()).equals("success")) {
            UserRole userRole = (UserRole) result.get("userInfo");
            Set<GrantedAuthority> grantedAuthority = new HashSet<>();
            List<Role> roles = userRole.getRoles();
            roles.forEach(role -> {
                grantedAuthority.add(new SimpleGrantedAuthority(role.getRoleName()));
            });
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userName, password, grantedAuthority);
            token.setDetails(request);
            Authentication auth = authenticationManager.authenticate(token);
            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(auth);
        }
        return result.get("status").toString();
    }

}
