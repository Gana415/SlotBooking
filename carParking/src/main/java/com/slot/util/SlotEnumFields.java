package com.slot.util;

public enum SlotEnumFields {

	PATH("D:\\\\Car\\\\parking_slot.txt"),
	PARK("park"), STATUS("status"), LEAVE("leave"),
	REGISTRATION("registration"),SLOT("slot"),
	REG_COL("registration_numbers_for_cars_with_colour"),
	SLOT_COL("slot_numbers_for_cars_with_colour"),
	SLOT_NUM("slot_number_for_registration_number");

	private String status;

	SlotEnumFields(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
