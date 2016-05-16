package com.ge.mict.scannerdataanalysis.app.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ge.mict.scannerdataanalysis.app.domain.Hospital;
import com.ge.mict.scannerdataanalysis.app.domain.ProtocolView;
import com.ge.mict.scannerdataanalysis.app.domain.RefPhysicianView;
import com.ge.mict.scannerdataanalysis.app.domain.ScannerInfo;

public interface ScannerInfoRepository extends CrudRepository<ScannerInfo, String> {
	Iterable<ScannerInfo> getDistinctHospitalsByHospitalIDAndHospitalName(String hospitalID, String hospitalName);
	
	/**
     * Finds a person by using the last name as a search criteria.
     * @param lastName
     * @return  A list of persons whose last name is an exact match with the given last name.
     *          If no persons is found, this method returns an empty list.
     */
    @Query("SELECT DISTINCT s.hospitalName, s.hospitalID FROM ScannerInfo s")
    public Iterable<Hospital> findHospitals();
    
    //select SUM(protocolcost), Count(*) from scannerinfo where hospitalid=
    @Query("SELECT SUM(s.protocolCost) as totalRevToHospital, COUNT(*) as totalExamsReferred, refPhysician FROM ScannerInfo s WHERE s.hospitalID=:hospitalID GROUP BY s.refPhysician")
    public Iterable<RefPhysicianView> findRefphydetails(@Param("hospitalID") String hospitalID);
    
    @Query("SELECT COUNT(*) as protocolCount, refPhysician, protocolScanned FROM ScannerInfo s WHERE s.hospitalID=:hospitalID GROUP BY s.refPhysician, s.protocolScanned")
    public Iterable<ProtocolView> findProtocolAnalysis(@Param("hospitalID") String hospitalID);
    
    
//    @Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
//    public List<Person> find(@Param("lastName") String lastName);
    
    
    
}
