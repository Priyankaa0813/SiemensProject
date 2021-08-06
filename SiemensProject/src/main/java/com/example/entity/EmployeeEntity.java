package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Entity
@Table(name="Employee")
@JacksonXmlRootElement(localName="Employee")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empployeeId;
	
	@Column(name="empployeeName")
	private String empployeeName;
	
	@Column(name="empployeeAddress")
	private String empployeeAddress;
	
	@Column(name="orgId")
	private long orgId;

	public long getEmpployeeId() {
		return empployeeId;
	}

	public void setEmpployeeId(long empployeeId) {
		this.empployeeId = empployeeId;
	}

	public String getEmpployeeName() {
		return empployeeName;
	}

	public void setEmpployeeName(String empployeeName) {
		this.empployeeName = empployeeName;
	}

	public String getEmpployeeAddress() {
		return empployeeAddress;
	}

	public void setEmpployeeAddress(String empployeeAddress) {
		this.empployeeAddress = empployeeAddress;
	}

	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}
	

}
