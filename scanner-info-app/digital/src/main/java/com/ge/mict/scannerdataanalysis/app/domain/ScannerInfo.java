package com.ge.mict.scannerdataanalysis.app.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ScannerInfo {
	@Id
	@Column(length = 40)
	@GeneratedValue(generator = "randomId")
	@GenericGenerator(name = "randomId", strategy = "com.ge.mict.scannerdataanalysis.app.domain.RandomIdGenerator")
	private String id;

	private String hospitalID;
	private String hospitalName;
	private int examNo;
	private String refPhysician;
	private String protocolScanned;
	private int protocolCost;
	private String startDateTime;
	private String endDateTime;
	private String accumulatedDose;

	public ScannerInfo() {
	}

	public ScannerInfo(String hospitalID, String hospitalName, int examNo, String refPhysician, String protocolScanned,
			int protocolCost, String startDateTime, String endDateTime, String accumulatedDose, int systemID) {
		this.hospitalID = hospitalID;
		this.hospitalName = hospitalName;
		this.examNo = examNo;
		this.refPhysician = refPhysician;
		this.protocolScanned = protocolScanned;
		this.protocolCost = protocolCost;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.accumulatedDose = accumulatedDose;
		this.systemID = systemID;
	}

	public String getHospitalID() {
		return hospitalID;
	}

	public void setHospitalID(String hospitalID) {
		this.hospitalID = hospitalID;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public int getExamNo() {
		return examNo;
	}

	public void setExamNo(int examNo) {
		this.examNo = examNo;
	}

	public String getRefPhysician() {
		return refPhysician;
	}

	public void setRefPhysician(String refPhysician) {
		this.refPhysician = refPhysician;
	}

	public String getProtocolScanned() {
		return protocolScanned;
	}

	public void setProtocolScanned(String protocolScanned) {
		this.protocolScanned = protocolScanned;
	}

	public int getProtocolCost() {
		return protocolCost;
	}

	public void setProtocolCost(int protocolCost) {
		this.protocolCost = protocolCost;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getAccumulatedDose() {
		return accumulatedDose;
	}

	public void setAccumulatedDose(String accumulatedDose) {
		this.accumulatedDose = accumulatedDose;
	}

	public int getSystemID() {
		return systemID;
	}

	public void setSystemID(int systemID) {
		this.systemID = systemID;
	}

	private int systemID;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format(
				"{hospitalID:%s,hospitalName:%s,examNo:%s,refPhysician:%s,protocolScanned:%s,protocolCost:%s,startDateTime:%s,endDateTime:%s,accumulatedDose:%s,systemID:%s}",
				hospitalID, hospitalName, examNo, refPhysician, protocolScanned, protocolCost, startDateTime,
				endDateTime, accumulatedDose, systemID);
	}

}
