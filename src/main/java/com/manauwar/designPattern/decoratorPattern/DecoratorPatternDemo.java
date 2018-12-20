package com.manauwar.designPattern.decoratorPattern;

public class DecoratorPatternDemo {

	public static void main(String[] args) {

		Shape circle = new Circle();
		circle.draw();
		
		
		Shape redCircle = new RedShapeDecorator(new Circle());
		//redCircle.draw();
		
		Shape redRectangle = new RedShapeDecorator(new Rectangle());
		
		
		
		System.out.println("Circle with normal border");
		circle.draw();
		
		
		System.out.println("\nCircle of Red Color");
		redCircle.draw();
		
		System.out.println("\nRectangle of Red Color");
		redRectangle.draw();
		
		
	}

}
