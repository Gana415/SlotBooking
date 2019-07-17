package com.slot.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.slot.service.VehicleService;
import com.slot.serviceImpl.VehicleServiceImpl;
import com.slot.util.SlotEnumFields;

public class FileController {
	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader(SlotEnumFields.PATH.getStatus());
		BufferedReader br = new BufferedReader(fr);

		String data = "";
		data = br.readLine(); // get the total slots
		String[] str = data.split(" ");

		VehicleService obj = new VehicleServiceImpl();
		obj.createParkingSlot(Integer.parseInt(str[1]));

		while ((data = br.readLine()) != null) { // add this slots
			String[] parkData = data.split(" ");
			if (parkData[0].contains(SlotEnumFields.PARK.getStatus())) {
				obj.park(parkData[1], parkData[2]);
			} else {
				break;
			}
		}

		String[] leave = data.split(" ");

		obj.leave(Integer.parseInt(leave[1]));

		data = br.readLine();

		if (data.equalsIgnoreCase(SlotEnumFields.STATUS.getStatus())) {
			obj.status();
		}

		data = br.readLine();
		String[] updateSlot1 = data.split(" ");
		if (updateSlot1[0].contains(SlotEnumFields.PARK.getStatus())) {
			obj.park(updateSlot1[1], updateSlot1[2]);
		} else {
			System.out.println("Wrong Input!");
		}

		data = br.readLine();
		String[] updateSlot2 = data.split(" ");
		if (updateSlot2[0].contains(SlotEnumFields.PARK.getStatus())) {
			obj.park(updateSlot2[1], updateSlot2[2]);
		} else {
			System.out.println("Wrong Input!");
		}

		data = br.readLine();
		String[] regSlot1 = data.split(" ");
		obj.findRegNumbersSlots(regSlot1[1], SlotEnumFields.REGISTRATION.getStatus());

		data = br.readLine();
		String[] regSlot2 = data.split(" ");
		obj.findRegNumbersSlots(regSlot2[1], SlotEnumFields.SLOT.getStatus());

		data = br.readLine();
		String[] slotSplit1 = data.split(" ");
		obj.findSlot(slotSplit1[1]);

		data = br.readLine();
		String[] slotSplit2 = data.split(" ");
		obj.findSlot(slotSplit2[1]);

	}

}
