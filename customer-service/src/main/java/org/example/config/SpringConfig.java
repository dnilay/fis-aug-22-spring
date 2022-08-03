package org.example.config;

import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages = "org.example")
public class SpringConfig {

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}

	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hr");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setMaxIdleTime(3000);
		dataSource.setMinPoolSize(5);
		dataSource.setMaxPoolSize(20);
		return dataSource;
	}

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

}
