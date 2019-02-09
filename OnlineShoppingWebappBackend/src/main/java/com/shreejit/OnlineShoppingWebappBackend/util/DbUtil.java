package com.shreejit.OnlineShoppingWebappBackend.util;

import java.util.Properties;

import javax.activation.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.shreejit.OnlineShoppingWebappBackend.dto" })
@EnableTransactionManagement
public class DbUtil {

	// Configuration based on MySQL DBMS
	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	// private static final String DATABASE_NAME = "shopping_database";
	private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3307/shopping_database";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "admin";
	// MySQL Hibernate Dialect
	private static final String DATABASE_DIALECT = "org.hibernate.dialect.MySQL5InnoDBDialect";

	// DataSource Bean to Provide the connection information
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		// Providing the database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);

		return (DataSource) dataSource;
	}

	// SessionFactory Bean
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder((javax.sql.DataSource) dataSource);
		builder.addProperties(getHibernateProperties());
		
		builder.scanPackages("com.shreejit.OnlineShoppingWebappBackend.dto");
		return builder.buildSessionFactory();
	}
	
	
	//All the hibernate properties will be written in this method
	private Properties getHibernateProperties() {
		// TODO Auto-generated method stub
		Properties properties=new Properties();
		
		//the place where hibernate database dialect is used as its the property of hibernate
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		return properties;
	}
	
	
	
	//Transaction Manager Bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}









