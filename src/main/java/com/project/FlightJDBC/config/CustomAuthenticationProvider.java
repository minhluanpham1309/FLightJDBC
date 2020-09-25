package com.project.FlightJDBC.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 *
 * @author Pham Minh Luan
 * @email phamminhluan@fabercompany.co.jp
 */
public class CustomAuthenticationProvider implements AuthenticationProvider{

    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
        return a;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
