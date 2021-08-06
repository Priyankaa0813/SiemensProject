package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@Entity
@Table(name="organization")
@JacksonXmlRootElement(localName="Organization")
public class OrganizationEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@JacksonXmlProperty(isAttribute = true)
	private long organizationId;
	
	@Column(name="organizationName")
	private String organizationName;
	
	@Column(name="organizationPlace")
	private String organizationPlace;
	
	@Column(name="organizationStocks")
	private String organizationStocks;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="org_fid", referencedColumnName = "organizationId") 
	List<EmployeeEntity> employees= new ArrayList<EmployeeEntity>();
	 
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="org_assert_fid", referencedColumnName = "organizationId")
	List<AssertsEntity> asserts= new ArrayList<AssertsEntity>();

	public long getOrganizationId() {
		return organizationId;
	}


	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}


	public String getOrganizationName() {
		return organizationName;
	}


	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}


	public String getOrganizationPlace() {
		return organizationPlace;
	}


	public void setOrganizationPlace(String organizationPlace) {
		this.organizationPlace = organizationPlace;
	}


	public String getOrganizationStocks() {
		return organizationStocks;
	}


	public void setOrganizationStocks(String organizationStocks) {
		this.organizationStocks = organizationStocks;
	}


	public List<EmployeeEntity> getEmployees() { return employees; }
	 

	public void setEmployees(List<EmployeeEntity> employees) { this.employees =
	  employees; }

	
	
	public List<AssertsEntity> getAsserts() {
		return asserts;
	}

	public void setAsserts(List<AssertsEntity> asserts) {
		this.asserts = asserts;
	}


	@Override
	public String toString() {
		return "OrganizationEntity [organizationId=" + organizationId + ", organizationName=" + organizationName
				+ ", organizationPlace=" + organizationPlace + ", organizationStocks=" + organizationStocks
				+ ", employees=" + employees + ", asserts=" + asserts + "]";
	}

	
	 
}
