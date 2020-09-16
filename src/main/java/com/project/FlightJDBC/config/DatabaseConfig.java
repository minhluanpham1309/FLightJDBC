package com.project.FlightJDBC.config;

import com.project.FlightJDBC.entity.Airport;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Pham Minh Luan <phamminhluan@fabercompany.co.jp>
 */
@Configuration
public class DatabaseConfig {

    //<editor-fold defaultstate="collapsed" desc="HIKARY DATASOURCE">
    @Bean
    public DataSource dataSource() {
        System.out.println("----HIKARY DATASOURCE----");
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:mysql://localhost:3306/dbFlights?useSSL=false");
        config.setUsername("root");
        config.setPassword("12345");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
      
        config.setMaximumPoolSize(5);

        HikariDataSource ds = new HikariDataSource(config);
        return ds;
    }
//</editor-fold>

}
