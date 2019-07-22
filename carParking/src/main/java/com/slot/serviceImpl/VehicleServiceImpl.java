package com.slot.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.slot.bean.CarParking;
import com.slot.bean.Vehicle;
import com.slot.service.VehicleService;
import com.slot.util.SlotEnumFields;

public class VehicleServiceImpl implements VehicleService {

	private static CarParking slotArray[];

	public int createParkingSlot(int totalSlots) {
		System.out.println("Created a parking lot with " + totalSlots + " slots");
		slotArray = new CarParking[totalSlots];
		lineBreak();
		return totalSlots;
	}

	public boolean park(String regNumber, String colour) {
		if (slotArray != null) {
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
		} else {
			System.out.println("ParkingSlots are not allocated ");
			lineBreak();
			return false;
		}

	}

	private CarParking setCarParking(String regNumber, String colour, int index) {
		CarParking obj = new CarParking(index, new Vehicle(regNumber, colour));
		return obj;
	}

	public boolean isExistReg(String regNumber) {
		return findByRegNumber(regNumber).size() > 0 ? true : false;
	}

	public int checkAvailableIndex() {
		int index = -1;
		OptionalInt optionalIndex = IntStream.range(0, slotArray.length).filter(i -> slotArray[i] == null).findFirst();
		if (optionalIndex.isPresent())
			index = optionalIndex.getAsInt();
		else
			index = -1;
		return index;
	}

	public boolean leave(int index) {
		if (slotArray != null && index < slotArray.length) {
			slotArray[index - 1] = null;
			System.out.println("Slot number " + (index) + " is free");
			lineBreak();
			return true;
		} else {
			System.out.println("ParkingSlots are not allocated this Index");
			return false;
		}

	}

	public List<CarParking> status() {
		System.out.println("Slot No.     " + "Registration No   " + "Colour");
		List<CarParking> listObj = null;
		if (slotArray != null) {
			listObj = findAll();
			if (listObj != null) {
				for (CarParking car : listObj) {
					System.out.print(car.getSlotId() + 1 + "\t \t");
					System.out.print(car.getVehicle().getRegNumber() + "\t \t");
					System.out.print(car.getVehicle().getColour());
					lineBreak();
				}
			} else {
				System.out.println("Data Not Found!");
			}
		} else {
			System.out.println("ParkingSlots are not allocated ");
		}
		lineBreak();
		return listObj;
	}

	public String findRegNumbersSlots(String colour, String type) {
		String print = "";
		if (slotArray != null) {
			List<CarParking> list = findByColour(colour);
			if (list != null) {
				for (CarParking car : list) {
					if (type.equalsIgnoreCase(SlotEnumFields.REGISTRATION.getStatus()))
						print += car.getVehicle().getRegNumber() + ",";
					else if (type.equalsIgnoreCase(SlotEnumFields.SLOT.getStatus()))
						print += (car.getSlotId() + 1) + ",";
				}
			} else {
				System.out.println(colour + " not found for this " + type);
			}
			System.out
					.println(!print.equals("") ? print = print.substring(0, print.length() - 1) : "Colour Not Found!");
		} else {
			System.out.println("ParkingSlots are not allocated ");
		}
		lineBreak();
		return print;
	}

	public int findSlot(String regNumber) {
		if (slotArray != null) {
			List<CarParking> list = findByRegNumber(regNumber);
			if (!list.isEmpty()) {
				System.out.println(list.get(0).getSlotId() + 1);
				lineBreak();
				return list.get(0).getSlotId() + 1;
			} else {
				System.out.println(regNumber + " not found");
				lineBreak();
				return 0;
			}
		} else {
			System.out.println("ParkingSlots are not allocated ");
			return 0;
		}
	}

	private List<CarParking> findAll() {
		return Arrays.asList(slotArray).stream().filter(c -> c != null).collect(Collectors.toList());
	}

	private List<CarParking> findByColour(String colour) {
		return Arrays.asList(slotArray).stream()
				.filter(c -> c != null && c.getVehicle().getColour().equalsIgnoreCase(colour))
				.collect(Collectors.toList());
	}

	private List<CarParking> findByRegNumber(String regNumber) {
		return Arrays.asList(slotArray).stream()
				.filter(c -> c != null && c.getVehicle().getRegNumber().equalsIgnoreCase(regNumber))
				.collect(Collectors.toList());
	}

	public void lineBreak() {
		System.out.println();
	}

}
