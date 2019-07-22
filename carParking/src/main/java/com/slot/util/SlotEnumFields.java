package com.slot.util;

public enum SlotEnumFields {

	REGISTRATION("registration"), SLOT("slot");

	private String status;

	SlotEnumFields(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
