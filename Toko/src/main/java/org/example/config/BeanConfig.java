package org.example.config;

import org.example.controller.BarangController;
import org.example.controller.IBarangController;
import org.example.repo.BarangRepo;
import org.example.repo.IBarangRepo;
import org.example.service.BarangService;
import org.example.service.IBarangService;
import org.example.util.MainMenu;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class BeanConfig {
    @Value("org.postgresql.Driver")
    private String dbDriver;

    @Value("jdbc:postgresql://localhost:5432/barang")
    private String url;

    @Value("tessu")
    private String dbUser;

    @Value("kosong")
    private String dbPassword;

    @Bean
    public IBarangRepo getBarangRepo(){
        return new BarangRepo(dataSource());
    }

    @Bean
    public IBarangService getBarangService(){
        return new BarangService(getBarangRepo());
    }

    @Bean
    public IBarangController getBarangController(){
        return new BarangController(getBarangService());
    }

    @Bean
    public MainMenu getMainMenu(){return new MainMenu(getBarangController());}


    @Bean
    DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(dbUser);
        driverManagerDataSource.setPassword(dbPassword);
        driverManagerDataSource.setDriverClassName(dbDriver);

        return driverManagerDataSource;
    }
}
