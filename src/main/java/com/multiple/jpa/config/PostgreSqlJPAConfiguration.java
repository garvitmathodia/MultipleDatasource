package com.multiple.jpa.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "com.multiple.jpa.orderrepository",
		entityManagerFactoryRef = "postgreSqlEntityManagerFactoryBean",
		transactionManagerRef = "postgreSqlTransactionManager"
)
public class PostgreSqlJPAConfiguration {

	@Bean 
	LocalContainerEntityManagerFactoryBean postgreSqlEntityManagerFactoryBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder , @Qualifier("postgreSqlDataSource") DataSource dataSource) {
		return entityManagerFactoryBuilder
				.dataSource(dataSource)
				.packages("com.multiple.jpa.orderentity")
				.build();
	}
	
	@Bean
	PlatformTransactionManager postgreSqlTransactionManager(@Qualifier("postgreSqlEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean emfb) {
		return new JpaTransactionManager(emfb.getObject());
	}
}

