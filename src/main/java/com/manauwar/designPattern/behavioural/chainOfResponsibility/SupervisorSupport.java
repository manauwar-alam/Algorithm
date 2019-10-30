package com.manauwar.designPattern.behavioural.chainOfResponsibility;

public class SupervisorSupport  implements SupportServiceITF {
	
	
	private SupportServiceITF next = null;
	
	public SupportServiceITF getNext() {
		return next;
	}

	public void setNext(SupportServiceITF next) {
		this.next = next;
	}


	@Override
	public void handleRequest(ServiceRequest request) {
		
		if(request.getType() == ServiceLevel.LEVEL_TWO)
        {
            request.setConclusion("Supervisor solved level two reuqest !!");
        }
        else
        {
            if(next != null){
                next.handleRequest(request);
            }
            else
            {
                throw new IllegalArgumentException("No handler found for :: " + request.getType());
            }
        }
		
	}

}
