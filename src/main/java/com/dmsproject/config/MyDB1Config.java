package com.dmsproject.config;

import com.dmsproject.dao.entity.db1.TimeSheet1DO;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.dmsproject.dao.repo.db1",
        entityManagerFactoryRef = "collegeEntityManagerFactory",
        transactionManagerRef = "collegeTransactionManager")
public class MyDB1Config {
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.db1")
    public DataSourceProperties collegeDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.db1.configuration")
    public DataSource collegeDataSource() {
        return collegeDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "collegeEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean collegeEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(collegeDataSource())
                .packages(TimeSheet1DO.class)
                .build();
    }

    @Primary
    @Bean(name = "collegeTransactionManager")
    public PlatformTransactionManager collegeTransactionManager(
            final @Qualifier("collegeEntityManagerFactory") LocalContainerEntityManagerFactoryBean collegeEntityManagerFactory) {
        return new JpaTransactionManager(collegeEntityManagerFactory.getObject());
    }
}

