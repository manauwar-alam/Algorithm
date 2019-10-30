package com.manauwar.designPattern.behavioural.visitor;

public class MacConfigurator implements RouterVisitor {

	@Override
	public void visit(DLinkRouter router) {
		System.out.println("DLinkRouter Configuration for MAC complete !!");

	}

	@Override
	public void visit(TPLinkRouter router) {
		
		System.out.println("TPLinkRouter Configuration for MAC complete !!");

	}

	@Override
	public void visit(NetgearRouter router) {

		System.out.println("NetGearRouter Configuration for MAC complete !!");

	}

}
