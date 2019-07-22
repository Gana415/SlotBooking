package com.slot.main;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.slot.service.VehicleService;
import com.slot.serviceImpl.VehicleServiceImpl;
import com.slot.util.EnumFields;

public class CmdController extends EnumFields {
	static Scanner slotsObj = new Scanner(System.in);
	static Map<String, String> map = new TreeMap<String, String>();

	public static void createMapInput() {
		map.put(CREATEPARKINGSLOTS, "<number>");
		map.put(PARK, "<registerNumber> <colour>");
		map.put(LEAVE, "<number>");
		map.put(STATUS, "<>");
		map.put(REG_COLOUR, "<colour>");
		map.put(SLOT_COLOUR, "<colour>");
		map.put(SLOT_REGISTRATION, "<registrationNumber>");
		map.put(EXIT, "<>");
	}

	public static void main(String[] args) {

		createMapInput();
		System.out.println("Please give the inputs below format\n");
		map.forEach((k, v) -> System.out.println("\t " + k + " " + v));
		VehicleService obj = new VehicleServiceImpl();
		while (true) {
			String data = callNewInput();
			String[] splitData = data.split(" ");
			if (splitData.length > 1) {
				switch (splitData[0]) {
				case CREATEPARKINGSLOTS:
					obj.createParkingSlot(Integer.parseInt(splitData[1]));
					break;
				case PARK:
					obj.park(splitData[1], splitData[2]);
					break;
				case LEAVE:
					obj.leave(Integer.parseInt(splitData[1]));
					break;
				case REG_COLOUR:
					obj.findRegNumbersSlots(splitData[1], "registration");
					break;
				case SLOT_COLOUR:
					obj.findRegNumbersSlots(splitData[1], "slot");
					break;
				case SLOT_REGISTRATION:
					obj.findSlot(splitData[1]);
					break;
				case EXIT:
					System.exit(0);
					break;
				default:
					System.out.println("Wrong Input Please Try Again");
				}
			} else {
				if (STATUS.equals(data)) {
					obj.status();
				}
			}
		}
	}

	public static String callNewInput() {
		return slotsObj.nextLine();
	}

}
