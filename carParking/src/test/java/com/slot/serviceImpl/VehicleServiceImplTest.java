package com.slot.serviceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.slot.service.VehicleService;
import com.slot.util.SlotEnumFields;

public class VehicleServiceImplTest {

	static VehicleService vehicleService;

	@BeforeClass
	public static void onlyOnce() {
		vehicleService = new VehicleServiceImpl();
	}

	@Test
	public void testcreateParkingSlot() {
		assertEquals(6, vehicleService.createParkingSlot(6));
	}

	@Test
	public void testpark() {

		vehicleService.createParkingSlot(6);
		assertTrue(vehicleService.park("KA­01­HH­1234", "White"));
		assertTrue(vehicleService.park("KA­01­HH­9999", "White"));
		assertTrue(vehicleService.park("KA­01­BB­0001", "Black"));
		assertTrue(vehicleService.park("KA­01­HH­7777", "Red"));
		assertTrue(vehicleService.park("KA­01­HH­2701", "Blue"));
		assertTrue(vehicleService.park("KA­01­HH­3141", "Black"));
	}

	@Test
	public void testleave() {
		vehicleService.createParkingSlot(2);
		vehicleService.park("KA­01­HH­1234", "White");
		vehicleService.park("KA­01­BB­0001", "Black");
		assertTrue(vehicleService.leave(1));
	}

	@Test
	public void teststatus() {
		vehicleService.createParkingSlot(2);
		vehicleService.park("KA­01­HH­1234", "White");
		vehicleService.park("KA­01­BB­0001", "Black");
		assertNotNull(vehicleService.status());
	}

	@Test
	public void testFindRegNumbersSlots() {
		vehicleService.createParkingSlot(2);
		vehicleService.park("KA­01­HH­1234", "White");
		vehicleService.park("KA­01­BB­0001", "Black");
		assertEquals("KA­01­HH­1234",
				vehicleService.findRegNumbersSlots("White", SlotEnumFields.REGISTRATION.getStatus()));
		assertEquals("2", vehicleService.findRegNumbersSlots("Black", SlotEnumFields.SLOT.getStatus()));
	}

	@Test
	public void testFindSlot() {
		vehicleService.createParkingSlot(2);
		vehicleService.park("KA­01­HH­1234", "White");
		vehicleService.park("KA­01­BB­0001", "Black");
		assertEquals(1, vehicleService.findSlot("KA­01­HH­1234"));
	}

}
