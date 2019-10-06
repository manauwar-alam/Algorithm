package com.manauwar.designPattern.creational.factory;

public class SmallCar extends Car {

	public SmallCar() {
		super(CarType.SMALL);
		consturct();
	}

	@Override
	protected void consturct() {
		
		System.out.println("Building Small Car");
		//Add accesories
		
	}

}
