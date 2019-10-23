package com.manauwar.designPattern.behavioural.strategy;

public class Demo {

	public static void main(String[] args) {
		
		
		// Creating social Media Connect Object for connecting with friend by
        // any social media strategy.
        SocialMediaContext context = new SocialMediaContext();
 
        // Setting Facebook strategy.
        context.setSocialMediaStrategy(new FacebookStrategy());
        context.connect("Manauwar");
 
        System.out.println("====================");
 
        // Setting Twitter strategy.
        context.setSocialMediaStrategy(new TwitterStrategy());
        context.connect("Manauwar");
 
        System.out.println("====================");
 
        // Setting GooglePlus strategy.
        context.setSocialMediaStrategy(new GooglePlusStrategy());
        context.connect("Manauwar");
 
        System.out.println("====================");
 
        // Setting Orkut strategy.
        context.setSocialMediaStrategy(new OrkutStrategy());
        context.connect("Manauwar");

	}

}
