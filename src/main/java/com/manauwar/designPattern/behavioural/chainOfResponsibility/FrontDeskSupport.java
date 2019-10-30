package com.manauwar.designPattern.behavioural.chainOfResponsibility;

public class FrontDeskSupport implements SupportServiceITF {
	
	private SupportServiceITF next = null;
	
	public SupportServiceITF getNext() {
		return next;
	}

	public void setNext(SupportServiceITF next) {
		this.next = next;
	}




	@Override
	public void handleRequest(ServiceRequest service) {
		
		 if(service.getType() == ServiceLevel.LEVEL_ONE)
	        {
	            service.setConclusion("Front desk solved level one reuqest !!");
	        }
	        else
	        {
	            if(next != null){
	                next.handleRequest(service);
	            }
	            else
	            {
	                throw new IllegalArgumentException("No handler found for :: " + service.getType());
	            }
	        }

	}

}
