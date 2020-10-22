package com.project.FlightJDBC.config;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan <phamminhluan@fabercompany.co.jp>
 */
@Configuration
public class DatabaseConfig {

//<editor-fold defaultstate="collapsed" desc="HIKARY DATASOURCE">
    @Bean
    public HikariDataSource dataSource() {
        System.out.println("----HIKARY DATASOURCE----");
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:mysql://localhost:3306/db_flights?allowPublicKeyRetrieval=true&useSSL=false");
        config.setUsername("root");
        config.setPassword("12345");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("characterEncoding", "utf8"); //tried with UTF-8 as well
        config.addDataSourceProperty("useUnicode", "true");
        config.setMaximumPoolSize(5);

        System.out.println("----Start HIKARY DATASOURCE----");
        HikariDataSource ds = new HikariDataSource(config);
        //ds.setAutoCommit(false);
        System.out.println("----End HIKARY DATASOURCE----");
        return ds;
    }
//</editor-fold>

}
