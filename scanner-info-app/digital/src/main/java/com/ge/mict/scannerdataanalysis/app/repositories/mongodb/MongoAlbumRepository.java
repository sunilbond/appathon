package com.ge.mict.scannerdataanalysis.app.repositories.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ge.mict.scannerdataanalysis.app.domain.Album;
import com.ge.mict.scannerdataanalysis.app.repositories.AlbumRepository;

@Repository
public interface MongoAlbumRepository extends MongoRepository<Album, String>, AlbumRepository {
}