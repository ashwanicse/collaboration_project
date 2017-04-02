package com.niit.collaboration.config;

import java.util.Properties;

import javax.sql.DataSource;

//import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/*
import com.niit.collaboration.dao.JobDAO;*/
//import com.niit.collaboration.dao.UserDAO;
/*import com.niit.collaboration.dao.impl.JobDAOImpl;*/
//import com.niit.collaboration.dao.impl.UserDAOImpl;


@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.niit.collaboration" })
@PropertySource(value = { "classpath:application.properties" })
public class ApplicationContextConfig {

	private static final Logger logger = 
			LoggerFactory.getLogger(ApplicationContextConfig.class);
 
/* @Bean(name = "dataSource")
 public DataSource getDataSource() {
 	BasicDataSource dataSource = new BasicDataSource();
 	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	dataSource.setUsername("NIIT_DB");//workspaceName at oracle side
	dataSource.setPassword("niit"); // password at the time of login   	
 	return dataSource;
 }
 
 
 private Properties getHibernateProperties() {
 	Properties properties = new Properties();
 	properties.put("hibernate.show_sql", "true");
 	properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
 	properties.put("hibernate.hbm2ddl.auto", "create");
 	return properties;
 }
 
 @Autowired
 @Bean(name = "sessionFactory")
 public LocalSessionFactoryBean sessionFactory() {
     LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
     sessionFactory.setDataSource(getDataSource());
     sessionFactory.setPackagesToScan(new String[] { "com.niit.collaboration.model" });
     sessionFactory.setHibernateProperties(getHibernateProperties());
     return sessionFactory;
  }
 
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	
    @Autowired
    @Bean(name = "userDAO")
    public UserDAO getUserDao(SessionFactory sessionFactory) {
    	return new UserDAOImpl();
    }
    @Autowired
    @Bean(name = "jobDAO")
    public JobDAO getJobDao(SessionFactory sessionFactory) {
    	return new JobDAOImpl();
    }*/
    @Autowired
    private Environment environment;
 
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.niit.collaboration.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }
     
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }
     
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;        
    }
     
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }

}
