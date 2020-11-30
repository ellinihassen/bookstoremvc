package com.vermeg.bookstoremvc.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.vermeg.bookstoremvc.dao.repository.impl")
@PropertySource(value = {"classpath:application.properties"})
public class HibernateConfiguration {

    @Autowired
    private Environment environment;

    private int getIntProperty(String propName) {

        String propVal = environment.getProperty(propName);

        int intPropVal = Integer.parseInt(propVal);

        return intPropVal;
    }


    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource myDataSource = new ComboPooledDataSource();
        try {
            myDataSource.setDriverClass(environment.getProperty("datasource.driver-class-name"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        myDataSource.setJdbcUrl(environment.getProperty("datasource.url"));
        myDataSource.setUser(environment.getProperty("datasource.username"));
        myDataSource.setPassword(environment.getProperty("datasource.password"));

        myDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        myDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return myDataSource;
    }

    @Bean
    public Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect",environment.getProperty("hibernate.dialect"));
        properties.setProperty("jpa.show-sql",environment.getProperty("jpa.show-sql"));
        properties.setProperty("hibernate.hbm2ddl.auto",environment.getProperty("hibernate.ddl-auto"));
        return properties;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
}
