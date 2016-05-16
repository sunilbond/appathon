package com.ge.mict.scannerdataanalysis.app.config.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("postgres-local")
public class PostgresLocalDataSourceConfig extends AbstractLocalDataSourceConfig {

	@Bean
	public DataSource dataSource() {
		return createBasicDataSource("jdbc:postgresql://localhost:5433/music", "org.postgresql.Driver", "postgres", "test123");
//		return createBasicDataSource("jdbc:postgresql://localhost/music", "org.postgresql.Driver", "postgres",
//				"postgres");
	}

}
