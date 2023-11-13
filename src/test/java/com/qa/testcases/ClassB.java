package com.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClassB extends ClassA {

	@BeforeClass
	public void beforeClassChild() {

		System.out.println("beforeClassChild");
	}

	@BeforeTest
	public void beforeTestChild() {

		System.out.println("beforeTestChild");

	}

	@BeforeMethod
	public void beforeMethodChild() {

		System.out.println("beforeMethodChild");
	}

	@AfterMethod
	public void afterMethodChild() {
		System.out.println("afterMethodChild");
	}

	@AfterTest
	public void afterTestChild() {
		System.out.println("afterTestChild");
	}

	@AfterClass
	public void afterClassChild() {
		System.out.println("afterClassChild");
	}

	@Test
	public void testB() {
		System.out.println("THIS IS THE CHILD TEST ");
	}

 
	
	
	
	
	
	
}

