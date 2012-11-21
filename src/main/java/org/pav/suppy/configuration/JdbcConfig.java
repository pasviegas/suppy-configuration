package org.pav.suppy.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:production-jdbc.properties")
public class JdbcConfig {

	@Value("${jdbc.driver}") 
	private String driver;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Bean
	@SuppressWarnings("deprecation")
	public DataSource dataSource() {
		return new DriverManagerDataSource(
				driver
			   ,url
			   ,username
			   ,password);
	}
}
