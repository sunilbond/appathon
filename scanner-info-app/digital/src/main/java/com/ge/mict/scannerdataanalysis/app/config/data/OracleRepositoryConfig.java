package com.ge.mict.scannerdataanalysis.app.config.data;

import org.hibernate.dialect.Oracle10gDialect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Profile("oracle")
@EnableJpaRepositories("com.ge.mict.scannerdataanalysis.app.repositories.jpa")
public class OracleRepositoryConfig extends AbstractJpaRepositoryConfig {

    protected String getHibernateDialect() {
        return Oracle10gDialect.class.getName();
    }

}
