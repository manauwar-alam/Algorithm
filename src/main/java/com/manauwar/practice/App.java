package com.manauwar.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */

import java.util.stream.*;

public class App 
{
	
	//use of flatmap
    public static void main( String[] args )
    {
       // System.out.println( "Hello World!" );
        
        
        List<String> l1 = Arrays.asList("a","b");
        List<String> l2 = Arrays.asList("c","d");
        System.out.println("real array l1 : "+l1);
        System.out.println("real array l2 : "+l2);
        System.out.println();
        
        List<String> l = new ArrayList<>();
        l.addAll(l1);
        l.addAll(l2);
        
        System.out.println("combined array l1+l2 : "+l);

        List<String> letters = l.stream()
        			.map(String::toUpperCase)
        			.collect(Collectors.toList());
        
        System.out.println("Convert to UPPERCASE with map : "+letters);
        System.out.println();
        
        
        List<String> betterLetters = Stream.of(l1, l2)
				.flatMap(List::stream)
				.map(String::toUpperCase)
				.collect(Collectors.toList());
        
        System.out.println("Combine l1 and l2 and convert to UPPERCASE with flatmap : "+betterLetters);
        
        
        
        
    }
}


class Employee 
{
	private Integer empId;
	private String name;
	private Double Salary;
	
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return Salary;
	}
	public void setSalary(Double salary) {
		Salary = salary;
	}
	
	
	
}


