package com.manauwar.designPattern.behavioural.visitor;

public interface Router {
	
	public void sendData(char [] data);
	public void acceptData(char[] data);
	
	public void accept(RouterVisitor visitor);

}
