package com.ge.mict.scannerdataanalysis.app.config.data;

import org.hibernate.dialect.H2Dialect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Profile("in-memory")
@EnableJpaRepositories("com.ge.mict.scannerdataanalysis.app.repositories.jpa")
public class LocalJpaRepositoryConfig extends AbstractJpaRepositoryConfig {

    protected String getHibernateDialect() {
        return H2Dialect.class.getName();
    }

}
