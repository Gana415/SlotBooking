package com.slot.serviceImpl;

import org.junit.BeforeClass;
import org.junit.Test;
import com.slot.service.VehicleService;
import com.slot.util.SlotEnumFields;

public class TestVehicleServiceImpl {

	static VehicleService vehicleService;

	@BeforeClass
	public static void onlyOnce() {
		vehicleService = new VehicleServiceImpl();
	}

	@Test
	public void testcreateParkingSlot() {
		vehicleService.createParkingSlot(6);
	}

	@Test
	public void testpark() {
		testcreateParkingSlot();
		vehicleService.park("KA­01­HH­1234", "White");
		vehicleService.park("KA­01­HH­9999", "White");
		vehicleService.park("KA­01­BB­0001", "Black");
		vehicleService.park("KA­01­HH­7777", "Red");
		vehicleService.park("KA­01­HH­2701", "Blue");
		vehicleService.park("KA­01­HH­3141", "Black");
	}

	@Test
	public void testleave() {
		testpark();
		vehicleService.leave(1);
	}

	@Test
	public void teststatus() {
		testpark();
		vehicleService.status();
	}

	@Test
	public void testFindRegNumbersSlots() {
		testpark();
		vehicleService.findRegNumbersSlots("White", SlotEnumFields.REGISTRATION.getStatus());
	}

	@Test
	public void testFindSlot() {
		testpark();
		vehicleService.findRegNumbersSlots("White", SlotEnumFields.SLOT.getStatus());
	}

}
