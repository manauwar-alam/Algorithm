package com.manauwar.designPattern.behavioural.chainOfResponsibility;

public class SupportService implements SupportServiceITF {
	
	private SupportServiceITF handler = null;

	@Override
	public void handleRequest(ServiceRequest request) {
		
		handler.handleRequest(request);
	}

	public SupportServiceITF getHandler() {
		return handler;
	}

	public void setHandler(SupportServiceITF handler) {
		this.handler = handler;
	}
	
	
}
