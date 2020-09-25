package com.project.FlightJDBC.config;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import java.util.Arrays;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan
 * @email phamminhluan@fabercompany.co.jp
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }*/

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.authorizeRequests().antMatchers("/login", "/logout").permitAll();
        
        http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");

        http.authorizeRequests().antMatchers("/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')");

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        http.authorizeRequests().and().formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/login")
                .defaultSuccessUrl("/web/listFlight")
                .failureUrl("/login?message=error")
                .usernameParameter("username")
                .passwordParameter("password")
                // Cấu hình cho Logout Page.
                .and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login?message=logout");

    }*/
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /* Create custom authentication provider */
        CustomAuthenticationProvider provider = new CustomAuthenticationProvider();
        auth.authenticationProvider(provider);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        System.out.println("\n################## Init Spring Security Config ##################");
        http.authorizeRequests().antMatchers("/index", "/listFlight").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')");
        http.authorizeRequests()
                .antMatchers("/admin/**")
                .hasAnyRole("ADMIN")
                .antMatchers("/login", "/checkLogin")
                .permitAll()
                .and()
                .formLogin().loginPage("/login");
        http.authorizeRequests().anyRequest().denyAll();

        /* enable CORS */
        /*http.cors().and();*/
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/static/**")
                .antMatchers("/static")
                .antMatchers("/error/**")
                .antMatchers("/error");
    }
    
    /*@Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(
                "https://" + "localhost:8080",
                "http://" + "localhost:8001"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }*/
}
