package com.manauwar.designPattern.structural.proxy;

public class RealObjectProxy extends RealObjectImp {
	
	@Override
	public void doSomething() {
		
		//perform additional logic and security
		//Even we can block the operation execution
		System.out.println("Delegating work on Real Object");
		super.doSomething();
	}

}
