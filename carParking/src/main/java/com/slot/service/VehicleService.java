package com.slot.service;

import java.util.List;

import com.slot.bean.CarParking;

public interface VehicleService {

	public int createParkingSlot(int totalSlots);

	public boolean park(String regNumber, String colour);

	public boolean leave(int index);

	public List<CarParking>  status();

	public String findRegNumbersSlots(String colour, String type);

	public int findSlot(String regNumber);

}
