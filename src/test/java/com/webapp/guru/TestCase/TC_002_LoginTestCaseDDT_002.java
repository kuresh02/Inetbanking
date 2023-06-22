package com.webapp.guru.TestCase;

import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.webapp.guru.PageObject.LoginPage;
import com.webapp.guru.Testutility.XLUtils;

public class TC_002_LoginTestCaseDDT_002 extends BaseClass {
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(user);
		logger.info("Username provided");
		lp.setPassword(pwd);
		logger.info("Password provided");
		lp.clickSubmit();
		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		} else {
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.warn("Login Passed");
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();

		}

	}

	public boolean isAlertPresent() // user defined method for created to check alert is present or not
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {

			return false;
		}
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir")+"/src/test/java/com/webapp/guru/TestData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		System.out.println(rownum);
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		System.out.println(colcount);
		String logindata[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		System.out.println(logindata[0].length);
		return logindata;
	}
}
