package com.shreejit.OnlineShoppingWebappBackend.util;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/* For doing certain configuration and creating the beans that is handled/managed by spring framework*/
@Configuration


/*
 * Will have the details about where the entity class resides, that the
 * hibernate uses
 */
@ComponentScan(basePackages = { "com.shreejit.OnlineShoppingWebappBackend" })

/* for handling the transaction of the data. The session must be managed within a transaction*/
@EnableTransactionManagement
public class DbUtil {

	/*
	 * // Configuration based on MySQL DBMS private final static String
	 * DATABASE_DRIVER = "com.mysql.jdbc.Driver"; // private final static String
	 * DATABASE_NAME = "shopping_database"; private final static String DATABASE_URL
	 * = "jdbc:mysql://127.0.0.1:3307/shopping_database"; private final static
	 * String DATABASE_USERNAME = "root"; private final static String
	 * DATABASE_PASSWORD = "admin"; // MySQL Hibernate Dialect private final static
	 * String DATABASE_DIALECT = "org.hibernate.dialect.MySQL5InnoDBDialect";
	 */

	// Configuration based on H2 Database DBMS
	private final static String DATABASE_DRIVER = "org.h2.Driverr";
	// private final static String DATABASE_NAME = "shopping_database";
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/shopping_database";
	private final static String DATABASE_USERNAME = "root";
	private final static String DATABASE_PASSWORD = "admin";
	// Hibernate Dialect
	private final static String DATABASE_DIALECT = " org.hibernate.dialect.H2Dialect";

	// dataSource Bean will be available by "getDataSource"--> to Provide the connection information
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		// Providing the database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;
	}

	// sessionFactory Bean will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.shreejit.OnlineShoppingWebappBackend");
		return builder.buildSessionFactory();
	}

	
	// All the hibernate properties will be written in this method
	private Properties getHibernateProperties() {
		// TODO Auto-generated method stub
		Properties properties = new Properties();

		/*
		 * the place where hibernate database dialect is used as its the property of
		 * hibernate
		 */
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");

		return properties;
	}

	// transactionManager Bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
