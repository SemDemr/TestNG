package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupsDemo {

	

	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Login on the dashboard");
	}
	
	
	@Test(priority=1)
	public void test1()
	{
		System.out.println("Adding employee!!!");
	}
	
	@Test(priority = 2, enabled=false)
	public void test2()
	{
		System.out.println("Removing employee!!!");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("Log out of the dashboard");
	}
	
	
	
	
}
