package com.traditional.yoga.dto.response;

import java.util.List;

import com.traditional.yoga.dto.ParameterSectionA;
import com.traditional.yoga.dto.ParameterSectionB;

public class ParameterResponse {

	private List<ParameterSectionA> sectionA;
	private List<ParameterSectionB> sectionB;

	public List<ParameterSectionA> getSectionA() {
		return sectionA;
	}

	public void setSectionA(List<ParameterSectionA> sectionA) {
		this.sectionA = sectionA;
	}

	public List<ParameterSectionB> getSectionB() {
		return sectionB;
	}

	public void setSectionB(List<ParameterSectionB> sectionB) {
		this.sectionB = sectionB;
	}

}
