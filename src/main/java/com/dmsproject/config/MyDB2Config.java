package com.dmsproject.config;

import com.dmsproject.dao.entity.db2.TimeSheet2DO;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.dmsproject.dao.repo.db2",
        entityManagerFactoryRef = "studentEntityManagerFactory",
        transactionManagerRef = "studentTransactionManager")
public class MyDB2Config {
    @Bean
    @ConfigurationProperties("spring.datasource.db2")
    public DataSourceProperties studentDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.db2.configuration")
    public DataSource studentDataSource() {
        return studentDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Bean(name = "studentEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean studentEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(studentDataSource())
                .packages(TimeSheet2DO.class)
                .build();
    }

    @Bean(name = "studentTransactionManager")
    public PlatformTransactionManager studentTransactionManager(
            final @Qualifier("studentEntityManagerFactory") LocalContainerEntityManagerFactoryBean studentEntityManagerFactory) {
        return new JpaTransactionManager(studentEntityManagerFactory.getObject());
    }
}

