package com.ge.mict.scannerdataanalysis.app.config.root;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ge.mict.scannerdataanalysis.app.config.data.LocalJpaRepositoryConfig;
import com.ge.mict.scannerdataanalysis.app.repositories.AlbumRepository;
import com.ge.mict.scannerdataanalysis.app.repositories.ScannerInfoRepository;

@Configuration
@ComponentScan(basePackageClasses = {ScannerInfoRepository.class, AlbumRepository.class, LocalJpaRepositoryConfig.class})
public class RepositoryConfig {
}

