package com.slot.serviceImpl;

import com.slot.bean.CarParking;
import com.slot.bean.Vehicle;
import com.slot.service.VehicleService;
import com.slot.util.SlotEnumFields;

public class VehicleServiceImpl implements VehicleService {

	private static CarParking slotArray[];

	public void createParkingSlot(int totalSlots) {
		System.out.println("Created a parking lot with " + totalSlots + " slots");
		slotArray = new CarParking[totalSlots];
		lineBreak();
	}

	public boolean park(String regNumber, String colour) {
		if (!isExistReg(regNumber)) {
			int index = checkAvailableIndex();
			if (index != -1) {
				CarParking obj = setCarParking(regNumber, colour, index);
				slotArray[index] = obj;
				System.out.println("Allocated slot number:" + (index + 1));
				lineBreak();
				return true;
			} else {
				System.out.println("Sorry, parking lot is full");
				lineBreak();
				return false;
			}

		} else {
			System.out.println("RegNumber Already Exist");
			lineBreak();
			return false;
		}
		
	}

	private CarParking setCarParking(String regNumber, String colour, int index) {
		CarParking obj = new CarParking();
		obj.setSlotId(index);
		Vehicle vechObj = new Vehicle();
		vechObj.setRegNumber(regNumber);
		vechObj.setColour(colour);
		obj.setVehicle(vechObj);
		return obj;
	}

	public boolean isExistReg(String regNumber) {
		boolean flag = false;
		for (int i = 0; i < slotArray.length; i++) {
			if (slotArray[i] != null) {
				CarParking car = slotArray[i];
				Vehicle vechical = car.getVehicle();
				if (vechical.getRegNumber().equalsIgnoreCase(regNumber)) {
					flag = true;
					break;
				}
			}
		}

		return flag;
	}

	public int checkAvailableIndex() {
		int index = -1;
		for (int i = 0; i < slotArray.length; i++) {
			if (slotArray[i] == null) {
				index = i;
				break;
			}
		}
		return index;
	}

	public boolean leave(int index) {
		slotArray[index - 1] = null;
		System.out.println("Slot number " + (index) + " is free");
		lineBreak();
		return true;
	}

	public void status() {
		System.out.println("Slot No.     " + "Registration No   " + "Colour");
		for (int i = 0; i < slotArray.length; i++) {
			if (slotArray[i] != null) {
				CarParking car = slotArray[i];
				Vehicle vechical = car.getVehicle();
				System.out.print(car.getSlotId() + 1 + "            ");
				System.out.print(vechical.getRegNumber() + "   ");
				System.out.print(vechical.getColour());
				lineBreak();
			}
		}
		lineBreak();
	}

	public void findRegNumbersSlots(String colour, String type) {
		String print = "";
		for (int i = 0; i < slotArray.length; i++) {
			if (slotArray[i] != null) {
				CarParking car = slotArray[i];
				Vehicle vechical = car.getVehicle();
				if (vechical.getColour().equalsIgnoreCase(colour)) {
					if (type.equalsIgnoreCase(SlotEnumFields.REGISTRATION.getStatus())) {
						print += vechical.getRegNumber() + " ,";
					} else if (type.equalsIgnoreCase(SlotEnumFields.SLOT.getStatus())) {
						print += (car.getSlotId() + 1) + " ,";
					}
				}
			}
		}

		System.out.println(!print.equals("") ? print.substring(0, print.length() - 1) : "Colour Not Found!");
		lineBreak();
	}

	public void findSlot(String regNumber) {
		int print = -1;
		for (int i = 0; i < slotArray.length; i++) {
			if (slotArray[i] != null) {
				CarParking car = slotArray[i];
				Vehicle vechical = car.getVehicle();
				if (vechical.getRegNumber().equalsIgnoreCase(regNumber)) {
					print = car.getSlotId();
				}

			}
		}
		if (print != -1) {
			System.out.println(print + 1);
		} else {
			System.out.println("Not found");
		}
		lineBreak();
	}

	public void lineBreak() {
		System.out.println();
	}

}
