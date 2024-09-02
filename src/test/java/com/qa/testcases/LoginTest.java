package com.qa.testcases;

import org.testng.annotations.Test;

import com.qa.pages.DashboardPageElements;
import com.qa.pages.LoginPageElements;
import com.qa.utils.ConfigsReader;


import org.testng.Assert;


public class LoginTest extends com.qa.utils.CommonMethods {
	
	
	@Test(groups = {"smoke","regression"})
	public void validLogin()
	{
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		
		test.info("Entering valid login credentials.");
		
		
		sendText(login.username,ConfigsReader.getProperty("username"));
		wait(1);
		sendText(login.password, ConfigsReader.getProperty("password"));
		wait(1);
		
		jsClick(login.logInButton);
		wait(2);
		test.info("Verifying that user is logged in.");
		String expected = "Jacqueline White";
		String actual = dashboard.accountName.getText();
		
		//assertion
		Assert.assertEquals(actual, expected, "The account name does NOT match!!");
	}
	
	@Test(groups = {"regression"})
	public void emptyPasswordLogin() {

		LoginPageElements login = new LoginPageElements();

		sendText(login.username, ConfigsReader.getProperty("username"));
		wait(1);
		sendText(login.password, "");
		wait(1);

		click(login.logInButton);
		wait(2);

		Boolean errorMessage = login.errorEmptyPassword.isDisplayed();

		Assert.assertTrue(errorMessage, " Error message is not displayed");

		String expected = "Password cannot be empty";

		String actual = login.errorEmptyPassword.getText();

		Assert.assertEquals(actual, expected, "Error message does not match!");

	}

	@Test(groups = {"regression"})
	public void invalidPasswordLogin() {

		LoginPageElements login = new LoginPageElements();

		sendText(login.username, ConfigsReader.getProperty("username"));
		wait(1);
		sendText(login.password, "Ndfggff");
		wait(1);

		click(login.logInButton);
		wait(2);

		String expected = "Invalid Credentials";

		Boolean errorMessage = login.errorInvalidPassword.isDisplayed();
		Assert.assertTrue(errorMessage, " Error message is not displayed");

		String actual = login.errorInvalidPassword.getText();

		Assert.assertEquals(actual, expected, "Error message is not same");
	}

	
	
	
	
	
	
	
	
	
	
	
}
