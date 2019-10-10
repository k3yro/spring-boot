package de.k3yro.mavenDemo.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
@Component
@Profile("dev")
public class DevDatasource implements Datasource {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    @Override
    public DataSource getSource() {
        return DataSourceBuilder
                .create()
                .url("jdbc:mysql://localhost:3306/spring_boot_mysql_database")
                .username("user")
                .password("geheim")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();
    }
}
