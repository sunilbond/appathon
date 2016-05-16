package com.ge.mict.scannerdataanalysis.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ProtocolView {
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
	private int protocolCount;
	private String protocolScanned;

	public ProtocolView() {
	}

	public ProtocolView(String refPhysician, int protocolCount, String protocolScanned) {
		this.refPhysician = refPhysician;
		this.protocolCount = protocolCount;
		this.protocolScanned = protocolScanned;
	}

	public String getRefPhysician() {
		return refPhysician;
	}

	public void setRefPhysician(String refPhysician) {
		this.refPhysician = refPhysician;
	}

	public int getProtocolCount() {
		return protocolCount;
	}

	public void setProtocolCount(int protocolCount) {
		this.protocolCount = protocolCount;
	}

	public String getProtocolScanned() {
		return protocolScanned;
	}

	public void setProtocolScanned(String protocolScanned) {
		this.protocolScanned = protocolScanned;
	}


}
