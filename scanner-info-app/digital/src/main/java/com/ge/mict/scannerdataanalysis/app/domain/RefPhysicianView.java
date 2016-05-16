package com.ge.mict.scannerdataanalysis.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class RefPhysicianView {
	@Id
	@Column(length = 40)
	@GeneratedValue(generator = "randomId")
	@GenericGenerator(name = "randomId", strategy = "com.ge.mict.scannerdataanalysis.app.domain.RandomIdGenerator")
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String refPhysician;
	private int totalExamsReferred;
	private int totalRevToHospital;

	public RefPhysicianView() {
	}
	
	public RefPhysicianView(String refPhysician, int totalExamsReferred, int totalRevToHospital) {
		this.refPhysician = refPhysician;
		this.totalExamsReferred = totalExamsReferred;
		this.totalRevToHospital = totalRevToHospital;
	}

	public String getRefPhysician() {
		return refPhysician;
	}

	public void setRefPhysician(String refPhysician) {
		this.refPhysician = refPhysician;
	}

	public int getTotalExamsReferred() {
		return totalExamsReferred;
	}

	public void setTotalExamsReferred(int totalExamsReferred) {
		this.totalExamsReferred = totalExamsReferred;
	}

	public int getTotalRevToHospital() {
		return totalRevToHospital;
	}

	public void setTotalRevToHospital(int totalRevToHospital) {
		this.totalRevToHospital = totalRevToHospital;
	}


}
