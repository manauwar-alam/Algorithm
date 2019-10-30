package com.manauwar.designPattern.behavioural.visitor;

public class DLinkRouter implements Router {

	@Override
	public void sendData(char[] data) {
		
	}

	@Override
	public void acceptData(char[] data) {

	}

	@Override
	public void accept(RouterVisitor visitor) {
		
		visitor.visit(this);
	}

}
