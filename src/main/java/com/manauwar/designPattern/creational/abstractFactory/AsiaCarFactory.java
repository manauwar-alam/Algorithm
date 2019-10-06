package com.manauwar.designPattern.creational.abstractFactory;

import com.manauwar.designPattern.creational.abstractFactory.SedanCar;
import com.manauwar.designPattern.creational.abstractFactory.SmallCar;

public class AsiaCarFactory {
	
	public static Car buildCar(CarType model) {
		
		Car car = null;
		
		switch(model) {
			
			case SMALL : 
				car = new SmallCar(Location.ASIA);
				break;
				
			case SEDAN :
				car =  new SedanCar(Location.ASIA);
				break;
				
			case LUXURY :
				car = new LuxuryCar(Location.ASIA);
				break;
				
			default :
				//add some exception here
				break;
				
			
		}
		
		return car;
		
	}

}
