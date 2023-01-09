package com.traditional.yoga.dto.request;

import com.traditional.yoga.model.PartofCountryModel;

public class RegionRequest {

	private int regionId;
	private String regionName;
	private String countryName;
	private PartofCountryModel partId;
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
