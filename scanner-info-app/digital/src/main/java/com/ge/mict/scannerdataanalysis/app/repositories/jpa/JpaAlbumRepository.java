package com.ge.mict.scannerdataanalysis.app.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ge.mict.scannerdataanalysis.app.domain.Album;
import com.ge.mict.scannerdataanalysis.app.repositories.AlbumRepository;

@Repository
public interface JpaAlbumRepository extends JpaRepository<Album, String>, AlbumRepository {
	
}
