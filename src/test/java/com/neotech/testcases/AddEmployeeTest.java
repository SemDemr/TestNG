package com.neotech.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.ExcelUtility;

public class AddEmployeeTest extends CommonMethods {

	@Test(dataProvider = "excelData", groups= {"AddEmployee","regression"})

	public void addEmployee(String firstName, String lastName, String username, String password) {

		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();

		sendText(login.username, ConfigsReader.getProperty("username"));

		wait(1);
		sendText(login.password, ConfigsReader.getProperty("password"));
		wait(1);

		jsClick(login.logInButton);
		wait(2);

		click(dashboard.pim);

		click(dashboard.addEmployee);
		wait(2);

		jsClick(dashboard.swBtn);

		sendText(dashboard.firstName, firstName);
		sendText(dashboard.lastName, lastName);
		sendText(dashboard.userName, username);
		sendText(dashboard.password, password);
		sendText(dashboard.cPassword, password);
		//selectDropdown(dashboard.location, location);

		String empID = dashboard.empID.getAttribute("value");

		click(dashboard.saveBtn);

		wait(2);

		waitForVisibility(dashboard.personalDts);

		String actualID = dashboard.empID.getAttribute("value");

		Assert.assertEquals(actualID, empID, "Employee IDs do not match!");

	}

	@DataProvider(name = "excelData")

	public Object[][] getExcelData() {
		return ExcelUtility.excelIntoArray(System.getProperty("user.dir") + "/src/test/resources/testdata/Excel.xlsx",
				"Employee");

	}

}
