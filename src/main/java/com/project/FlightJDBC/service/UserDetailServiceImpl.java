package com.project.FlightJDBC.service;

import com.project.FlightJDBC.entity.Role;
import com.project.FlightJDBC.entity.UserRole;
import com.project.FlightJDBC.repository.UserRoleRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
public class UserDetailServiceImpl implements UserDetailsService{
   
    @Autowired
    private UserRoleRepository userRoleRepo;
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserRole userRole = userRoleRepo.findUserRoleByUserName(userName);
        if(userRole == null){
            throw new UsernameNotFoundException("User not found");
        }
        Set<GrantedAuthority> grantedAuthor = new HashSet<>();
        List<Role> roles = userRole.getRoles();
        for(Role role: roles){
            grantedAuthor.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        
        return new User(userRole.getUserAccount(), userRole.getUserPassword(), grantedAuthor);
    }
}
