package com.manauwar.designPattern.creational.factory;

public class SedanCar extends Car {
	

	public SedanCar() {
		super(CarType.SEDAN);
		consturct();
	}

	
	@Override
	protected void consturct() {
		
		System.out.println("Building Sedan Car");
		//Add accessories
		
	}

}
