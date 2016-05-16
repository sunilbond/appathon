package com.ge.mict.scannerdataanalysis.app.config.data;

import org.hibernate.dialect.PostgreSQL82Dialect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Profile("postgres")
@EnableJpaRepositories("com.ge.mict.scannerdataanalysis.app.repositories.jpa")
public class PostgresRepositoryConfig extends AbstractJpaRepositoryConfig {

    protected String getHibernateDialect() {
        return PostgreSQL82Dialect.class.getName();
    }

}
