package com.multiple.jpa.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostgreSqlDatasourceConfiguration {
	
	@ConfigurationProperties("spring.datasource.pg")
	@Bean
	public DataSourceProperties postgreSqlDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	public DataSource postgreSqlDataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setUsername(mySqlDataSourceProperties().getUsername());
//		dataSource.setPassword(mySqlDataSourceProperties().getPassword());
//		dataSource.setUrl(mySqlDataSourceProperties().getPassword());
//		dataSource.setDriverClassName(mySqlDataSourceProperties().getDriverClassName());
//		return dataSource;
		
		return postgreSqlDataSourceProperties().initializeDataSourceBuilder().build();
	}
}
