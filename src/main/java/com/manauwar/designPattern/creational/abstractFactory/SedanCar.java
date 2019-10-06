package com.manauwar.designPattern.creational.abstractFactory;

public class SedanCar extends Car {

	public SedanCar(Location location) {
		
		super(CarType.SEDAN, location);
		construct();
	}

	@Override
	protected void construct() {
		
		System.out.println("Building Sedan car");
		//add accessories

	}
	

}
