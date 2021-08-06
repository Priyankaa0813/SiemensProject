package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@Entity
@Table(name="Asserts")
@JacksonXmlRootElement(localName="Asserts")
public class AssertsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long assertId;
	
	@Column(name="assertName")
	@NotNull
	@Size(min=2, max=30)
	private String assertName;
	
	@Column(name="orgId")
	private String orgId;
	
	@Column(name="assertType")
	private String assertType;

	public long getAssertId() {
		return assertId;
	}

	public void setAssertId(long assertId) {
		this.assertId = assertId;
	}

	public String getAssertName() {
		return assertName;
	}

	public void setAssertName(String assertName) {
		this.assertName = assertName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getAssertType() {
		return assertType;
	}

	public void setAssertType(String assertType) {
		this.assertType = assertType;
	}

	
}
