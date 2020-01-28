package com.model;

public class Building {
	private double width;
	private double height;
	private String name;
	private int noOfFloors;
	private int apartmentPerFloor;
	private boolean isSwimmingPoolPresent;
	
	public String toString() {
		return "Width="+width+",Height="+height+",Name="+name+",No.Of floors="+noOfFloors+",Apartment Per Floor="+apartmentPerFloor
				+",Swimming pool is "+(isSwimmingPoolPresent == true?"Present":"Absent") ;
	}
	public Building(BuildingBuilder bb) {
		super();
		this.width = bb.width;
		this.height = bb.height;
		this.name = bb.name;
		this.noOfFloors = bb.noOfFloors;
		this.apartmentPerFloor = bb.apartmentPerFloor;
		this.isSwimmingPoolPresent = bb.isSwimmingPoolPresent;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public String getName() {
		return name;
	}

	public int getNoOfFloors() {
		return noOfFloors;
	}

	public int getApartmentPerFloor() {
		return apartmentPerFloor;
	}

	public boolean isSwimmingPoolPresent() {
		return isSwimmingPoolPresent;
	}

	public static class BuildingBuilder{
		private double width;
		private double height;
		private String name;
		private int noOfFloors;
		private int apartmentPerFloor;
		private boolean isSwimmingPoolPresent;
		public BuildingBuilder setWidth(double width) {
			this.width = width;
			return this;
		}
		public BuildingBuilder setHeight(double height) {
			this.height = height;
			return this;
		}
		public BuildingBuilder setName(String name) {
			this.name = name;
			return this;
		}
		public BuildingBuilder setNoOfFloors(int noOfFloors) {
			this.noOfFloors = noOfFloors;
			return this;
		}
		public BuildingBuilder setApartmentPerFloor(int apartmentPerFloor) {
			this.apartmentPerFloor = apartmentPerFloor;
			return this;
		}
		public BuildingBuilder setSwimmingPoolPresent(boolean isSwimmingPoolPresent) {
			this.isSwimmingPoolPresent = isSwimmingPoolPresent;
			return this;
		}
		public Building build() {
			return new Building(this);
		}
	}
}
