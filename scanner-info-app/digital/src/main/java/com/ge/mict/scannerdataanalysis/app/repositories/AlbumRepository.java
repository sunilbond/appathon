package com.ge.mict.scannerdataanalysis.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ge.mict.scannerdataanalysis.app.domain.Album;

public interface AlbumRepository extends CrudRepository<Album, String> {
}
