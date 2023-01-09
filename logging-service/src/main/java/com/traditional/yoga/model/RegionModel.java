package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "region")
public class RegionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "region_id")
	private int regionId;

	@Column(name = "region_name")
	private String regionName;

	@Column(name = "country")
	private String countryName;

	@OneToOne
	@JoinColumn(name = "part_of_country_id", referencedColumnName = "part_id")
	private PartofCountryModel partId;

	@Column(name = "states")
	private String states;

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public PartofCountryModel getPartId() {
		return partId;
	}

	public void setPartId(PartofCountryModel partId) {
		this.partId = partId;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}

}
