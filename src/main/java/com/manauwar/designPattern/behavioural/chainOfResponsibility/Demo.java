package com.manauwar.designPattern.behavioural.chainOfResponsibility;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
        SupportService supportService = (SupportService) context.getBean("supportService");
        
 
        ServiceRequest request = new ServiceRequest();
        request.setType(ServiceLevel.LEVEL_ONE);
        supportService.handleRequest(request);
        System.out.println(request.getConclusion());
        
        request = new ServiceRequest();
        request.setType(ServiceLevel.LEVEL_TWO);
        supportService.handleRequest(request);
        System.out.println(request.getConclusion());
 
        request = new ServiceRequest();
        request.setType(ServiceLevel.LEVEL_THREE);
        supportService.handleRequest(request);
        System.out.println(request.getConclusion());
 
        request = new ServiceRequest();
        request.setType(ServiceLevel.INVALID_REQUEST);
        supportService.handleRequest(request);
        System.out.println(request.getConclusion());

	}

}
