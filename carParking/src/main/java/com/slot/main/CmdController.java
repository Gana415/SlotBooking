package com.slot.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.slot.service.VehicleService;
import com.slot.serviceImpl.VehicleServiceImpl;
import com.slot.util.SlotEnumFields;

public class CmdController {
	static Scanner slotsObj = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		VehicleService obj = new VehicleServiceImpl();

		System.out.println("Please enter Number of Slots");
		int slots = Integer.parseInt(callNewInput());
		obj.createParkingSlot(slots);
		System.out.println("Created a parking lot with " + slots + " slots");
		System.out.println();
		Map<Integer, Map<String, String>> slotMap = new HashMap<Integer, Map<String, String>>();

		for (int i = 0; i < slots; i++) {
			System.out.println("Adding your slot");
			String newSlot = callNewInput();
			System.out.println("You typed: " + newSlot);

			String[] parkData = newSlot.split(" ");
			if (parkData[0].contains(SlotEnumFields.PARK.getStatus())) {
				obj.park(parkData[1], parkData[2]);
			} else {
				System.out.println("Wrong Input Please Try Again!");
				System.exit(0);
				break;
			}

		}
		String data = "";
		System.out.print(SlotEnumFields.LEAVE.getStatus() + " ");

		obj.leave(Integer.parseInt(callNewInput()));

		System.out.println("Print status of List:");
		data = callNewInput();
		if (data.equalsIgnoreCase(SlotEnumFields.STATUS.getStatus())) {
			obj.status();
		}

		System.out.println("Update new Regester Number");
		data = callNewInput();
		String[] updateSlot1 = data.split(" ");
		if (updateSlot1[0].contains(SlotEnumFields.PARK.getStatus())) {
			obj.park(updateSlot1[1], updateSlot1[2]);
		} else {
			System.out.println("Wrong Input!");
		}

		System.out.println("Update new Regester Number");
		data = callNewInput();
		String[] updateSlot2 = data.split(" ");
		if (updateSlot2[0].contains(SlotEnumFields.PARK.getStatus())) {
			obj.park(updateSlot2[1], updateSlot2[2]);
		} else {
			System.out.println("Wrong Input!");
		}

		System.out.println("Enter registration_numbers Color Name ");
		data = callNewInput();
		String[] regSlot1 = data.split(" ");
		obj.findRegNumbersSlots(regSlot1[1], "registration");

		System.out.println("Enter slot_numbers_for_cars Color Name ");
		data = callNewInput();
		String[] regSlot2 = data.split(" ");
		obj.findRegNumbersSlots(regSlot2[1], "slot");

		System.out.println("Enter Regester Number ");
		data = callNewInput();
		String[] slotSplit1 = data.split(" ");
		obj.findSlot(slotSplit1[1]);
		System.out.println("Enter Regester Number ");
		data = callNewInput();
		String[] slotSplit2 = data.split(" ");
		obj.findSlot(slotSplit2[1]);
	}

	public static String callNewInput() {
		return slotsObj.nextLine();
	}

}
