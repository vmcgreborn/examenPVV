package com.pvv.app.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
		basePackages = "com.pvv.app.rep", //cambiar a su paquete de DAO una vez se tenga base de datos
		entityManagerFactoryRef="entityManagerFactory",	
		transactionManagerRef = "transactionManager"
		
		)//por default asi si manejamos varios abra que hacer varios paquetes--------entityManagerFactoryRef="entityManagerFactory"
		
public class PersistenceConfig {


	@Primary
	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DataSourceProperties.CRM_DRIVER);
		dataSource.setUrl(DataSourceProperties.CRM_URL);
		dataSource.setUsername(DataSourceProperties.CRM_USER);
		dataSource.setPassword(DataSourceProperties.CRM_PASSWORD);
		return dataSource;
	}
	
	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory (
			EntityManagerFactoryBuilder  builder,
			@Qualifier("dataSource") DataSource dataSource
			) {
		return builder.dataSource(dataSource).packages("com.pvv.app.model").persistenceUnit("PU-PST").build();//cambiar a su paquete de modelo una vez se tenga base de datos
	}
	
	@Primary
	@Bean (name = "transactionManager")
	public PlatformTransactionManager transactionManager (
			@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
    
}
