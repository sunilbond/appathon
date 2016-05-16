package com.ge.mict.scannerdataanalysis.app.repositories.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ge.mict.scannerdataanalysis.app.domain.ScannerInfo;
import com.ge.mict.scannerdataanalysis.app.repositories.ScannerInfoRepository;

@Repository
public interface JpaScannerInfoRepository extends JpaRepository<ScannerInfo, String>, ScannerInfoRepository {
//	@Query("distinct hospitalid, hospitalname from scannerinfo")
//	public Iterable<Object> findAllHospitals();
	
	//List<ScannerInfo> getDistinctHospitalsByHospitalIDAndHospitalName();
	
	
}
