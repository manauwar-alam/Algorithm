package com.manauwar.designPattern.decoratorPattern;

public abstract class ShapeDecorator implements Shape {
	
	
	protected Shape decoratedShape;
	
	ShapeDecorator(Shape decorator)
	{
		this.decoratedShape = decorator;
	}
	

	@Override
	public void draw() {
		
		decoratedShape.draw();
		
	}

}
