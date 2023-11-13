package com.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClassA {

	@BeforeClass
	public void beforeClassParent() {
		System.out.println("beforeClassParent");
	}

	@BeforeTest
	public void beforeTestParent() {

		System.out.println("beforeTestParent");

	}

	@BeforeMethod
	public void beforeMethodParent() {

		System.out.println("beforeMethodParent");
	}

	@AfterMethod
	public void afterMethodParent() {
		System.out.println("afterMethodParent");
	}

	@AfterTest
	public void afterTestParent() {
		System.out.println("afterTestParent");
	}

	@AfterClass
	public void afterClassParent() {
		System.out.println("afterClassParent");
	}

	
	
	@Test
	public void testA() {
		
		System.out.println("THIS IS THE PARENT TEST");
		
		
	}
	
	
	
}
