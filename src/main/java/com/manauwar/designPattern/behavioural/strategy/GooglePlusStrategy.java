package com.manauwar.designPattern.behavioural.strategy;

public class GooglePlusStrategy implements ISocialMediaStrategy {

	@Override
	public void connectTo(String friendName) {
		
		System.out.println("Connecting with " + friendName + " through Google plus");

	}

}
