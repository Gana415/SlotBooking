package com.slot.service;

public interface VehicleService {

	public void createParkingSlot(int totalSlots);

	public boolean park(String regNumber, String colour);

	public boolean leave(int index);

	public void status();

	public void findRegNumbersSlots(String colour, String type);

	public void findSlot(String regNumber);

}
