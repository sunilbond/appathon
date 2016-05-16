package com.ge.mict.scannerdataanalysis.app.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hospital {
	@Id
	@Column(length = 40)
	@GeneratedValue(generator = "randomId")
	@GenericGenerator(name = "randomId", strategy = "com.ge.mict.scannerdataanalysis.app.domain.RandomIdGenerator")

	private String hospitalID;
	private String hospitalName;

	public Hospital() {
	}

	public Hospital(String hospitalID, String hospitalName) {
		this.hospitalID = hospitalID;
		this.hospitalName = hospitalName;
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


}
