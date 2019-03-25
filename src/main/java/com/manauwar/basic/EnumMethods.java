package com.manauwar.basic;

public class EnumMethods {

	public static void main(String[] args) {
		
		/*
		 * In order to call Enum’s method, we can not just directly call as usual
		 * class’s method “myClass.doSomething()”. Instead, we must assign a value to
		 * the Enum before we can invoke the method.
		 */
		
		Day day1 = Day.THURSDAY;
		System.out.println(String.format("[%s] is weekend? [%b]", day1, day1.isWeekend()));
		/*$>  [THURSDAY] is weekend? [false] */

		Day day2 = Day.SATURDAY;
		System.out.println(String.format("[%s] is weekend? [%b]", day2, day2.isWeekend()));
		/*$>  [SATURDAY] is weekend? [true] */
		

	}

}


 enum Day {

	MONDAY, TUESDAY,
	WEDNESDAY, THURSDAY,
    FRIDAY, SATURDAY,
    SUNDAY;

	public boolean isWeekday() {
		return (equals(MONDAY) ||
				equals(TUESDAY) ||
				equals(WEDNESDAY) ||
				equals(THURSDAY) ||
				equals(FRIDAY));
	}

	public boolean isWeekend() {
		return (equals(SATURDAY) || equals(SUNDAY));
	}

}


