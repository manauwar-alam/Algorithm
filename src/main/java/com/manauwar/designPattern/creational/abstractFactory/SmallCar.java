package com.manauwar.designPattern.creational.abstractFactory;

public class SmallCar extends Car {

	public SmallCar(Location location) {
		
		super(CarType.SMALL, location);
		construct();
	}

	@Override
	protected void construct() {
		
		System.out.println("Building Small car");
		//add accessories

	}

}
