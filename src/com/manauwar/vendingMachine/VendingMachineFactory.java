package com.manauwar.vendingMachine;

public class VendingMachineFactory {

	
	public static VendingMachine createVendingMachine() {
        return new VendingMachineImpl();
    }


	
}
