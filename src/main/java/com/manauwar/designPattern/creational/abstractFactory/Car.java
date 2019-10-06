package com.manauwar.designPattern.creational.abstractFactory;

public abstract class Car {
	
	private CarType model = null;
	private Location location = null;
	
	public Car(CarType model, Location location) {
		
		this.setModel(model);
		this.setLocation(location);
	}
	
	//do subclass level processing in this method
	protected abstract void construct();

	public CarType getModel() {
		return model;
	}

	public void setModel(CarType model) {
		this.model = model;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	@Override
	  public String toString() {
	    return "Model- "+model + " built in "+location;
	  }

}
