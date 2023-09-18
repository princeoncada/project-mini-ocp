package com.mmcm.projectocp.backend.spring.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
class SpringConfig {

    // DataSource connects to Database using JDBC Connector
    @Bean
    fun dataSource(): DataSource {
        val dataSource = DriverManagerDataSource()
        dataSource.apply {
            setDriverClassName("com.mysql.cj.jdbc.Driver")
            url = "jdbc:mysql://localhost:3306/db_test"
            username = "user"
            password = "pass"
        }
        return dataSource
    }

    // JDBC Template for query execution
    @Bean
    fun createJdbcTemplate(): JdbcTemplate {
        return JdbcTemplate(dataSource())
    }
}