package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "m_india_states")
public class StatesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "states_id")
	private int statesId;

	@ManyToOne
	@JoinColumn(name = "country_id", referencedColumnName = "country_id")
	private CountryModel country;

	@Column(name = "states_name")
	private String statesName;

	public int getStatesId() {
		return statesId;
	}

	public void setStatesId(int statesId) {
		this.statesId = statesId;
	}

	public CountryModel getCountry() {
		return country;
	}

	public void setCountry(CountryModel country) {
		this.country = country;
	}

	public String getStatesName() {
		return statesName;
	}

	public void setStatesName(String statesName) {
		this.statesName = statesName;
	}

}
