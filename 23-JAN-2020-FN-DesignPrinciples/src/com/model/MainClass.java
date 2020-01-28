package com.model;

public class MainClass {
	public static void main(String[] args) {
		Building b=new Building.BuildingBuilder()
				.setName("Eeshwara Vilas")
				.setHeight(100)
				.setWidth(75)
				.setNoOfFloors(10)
				.setApartmentPerFloor(4)
				.setSwimmingPoolPresent(true)
				.build();
		System.out.println(b.toString());
		
		Building b2=new Building.BuildingBuilder()
				.setName("Kalpana Vilas")
				.setHeight(100)
				.setWidth(75)
				.setNoOfFloors(10)
				.build();
		System.out.println(b2);
	}
}
