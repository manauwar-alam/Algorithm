package com.manauwar.designPattern.creational.abstractFactory;

public class CarFactory {
	
	private CarFactory() {
	    //Prevent instantiation
	  }
	 
	  public static Car buildCar(CarType type)
	  {
	    Car car = null;
	    //Location location = Location.ASIA; //Read location property somewhere from configuration
	    Location location = Location.USA;
	    
	    //Use location specific car factory
	    switch(location)
	    {
	      case USA:
	        car = USACarFactory.buildCar(type);
	        break;
	      case ASIA:
	        car = AsiaCarFactory.buildCar(type);
	        break;
	      default:
	        car = DefaultCarFactory.buildCar(type);
	    }
	  return car;
	  }

}
