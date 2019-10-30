package com.manauwar.designPattern.behavioural.visitor;

public class LinuxConfigurator implements RouterVisitor {

	@Override
	public void visit(DLinkRouter router) {
		
		System.out.println("DLinkRouter Configuration for Linux complete !!");

	}

	@Override
	public void visit(TPLinkRouter router) {
		
		System.out.println("TPLinkRouter Configuration for Linux complete !!");

	}

	@Override
	public void visit(NetgearRouter router) {
		
		System.out.println("NetGearRouter Configuration for Linux complete !!");

	}

}
