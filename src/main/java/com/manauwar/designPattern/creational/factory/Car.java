package com.manauwar.designPattern.creational.factory;

public abstract class Car {
	
	private CarType model = null;
	
	public Car(CarType model) {
		
		this.setModel(model);
		arrangeParts();
	}
	
	
	public CarType getModel() {
		return model;
	}

	public void setModel(CarType model) {
		this.model = model;
	}

	//do subclass level processing in this method
	protected abstract void consturct();
	

	private void arrangeParts() {
		
		//do one time processing here
	}
	
	

}
