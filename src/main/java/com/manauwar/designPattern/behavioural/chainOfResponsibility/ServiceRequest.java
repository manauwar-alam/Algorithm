package com.manauwar.designPattern.behavioural.chainOfResponsibility;

public class ServiceRequest {
	
	private ServiceLevel type;
	private String Conclusion;
	
	public ServiceLevel getType() {
		return type;
	}
	public void setType(ServiceLevel type) {
		this.type = type;
	}
	public String getConclusion() {
		return Conclusion;
	}
	public void setConclusion(String conclusion) {
		Conclusion = conclusion;
	}
	
	

}
