package com.slot.bean;

import java.io.Serializable;

public class Vehicle implements Serializable {

	private String regNumber;
	private String colour;

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Vehicle [regNumber=" + regNumber + ", colour=" + colour + "]";
	}

}
