package com.manauwar.designPattern.creational.factory;

public class LuxuryCar extends Car {

	public LuxuryCar() {
		super(CarType.LUXURY);
		consturct();
	}

	@Override
	protected void consturct() {
		
		System.out.println("Building Luxury Car");
		//add accessories
		
	}
	
	

	

}
