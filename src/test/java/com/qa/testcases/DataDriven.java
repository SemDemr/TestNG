package com.qa.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utils.ExcelUtility;

public class DataDriven {

	@Test(dataProvider = "excelData")
	public void printInformation(String name, String lastName, String age) {

		System.out.println(name + lastName + age);

	}

	@DataProvider
	public Object[][] createData() {

		Object[][] data = { { "John", "Smith", 25 }, { "Kevin", "Brown", 25 } };

		return data;

	}

	@DataProvider(name = "excelData")
	public Object[][] getExcelData() {

		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/DataProvider.xlsx";
		String sheet = "Data";

		Object[][] data = ExcelUtility.excelIntoArray(path, sheet);

		return data;
	}

}
