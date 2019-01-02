package com.manauwar.basic;

public class EnumExample {
	
	public static void main(String ...a)
	{
		Direction north = Direction.NORTH;
		System.out.println(north);
		
		//System.out.println(north.angle);    //will give error since angle is private
		System.out.println(north.getAngle());
		
		System.out.println(Direction.NORTH.getAngle());
		
		
		Direction [] directions = Direction.values();
		for(Direction direction : directions)
		{
			System.out.println(direction);
			System.out.println(direction.getAngle());
		}
		
		
	}
	
}	


//all enum types are singleton by default
	
	enum Direction
	{
		EAST(0),NORTH(90),WEST(180),SOUTH(270);
		
		private int angle;
		private Direction(final int angle)
		{
			this.angle = angle;
		}
		
		public int getAngle()
		{
			return angle;
		}
	}

