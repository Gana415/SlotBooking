package com.slot.bean;

import java.io.Serializable;

public class CarParking implements Serializable {
	private int slotId;
	private Vehicle vehicle;

	public CarParking(int slotId, Vehicle vehicle) {
		this.slotId = slotId;
		this.vehicle = vehicle;
	}

	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "CarParking [slotId=" + slotId + ", vehicle=" + vehicle + "]";
	}

}
