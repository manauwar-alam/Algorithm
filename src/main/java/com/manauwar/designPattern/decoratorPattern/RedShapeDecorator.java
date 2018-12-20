package com.manauwar.designPattern.decoratorPattern;

public class RedShapeDecorator extends ShapeDecorator {
	

	RedShapeDecorator(Shape decoratedShape)
	{
		super(decoratedShape);
	}
	
	
	@Override
	public void draw()
	{
		decoratedShape.draw();
		setRedBorder(decoratedShape);
	}
	
	
	void setRedBorder(Shape decoratedShape)
	{
		System.out.println("Border Color : Red");
	}

}
