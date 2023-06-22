package com.webapp.guru.TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.webapp.guru.PageObject.LoginPage;

public class Hm extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException {
//		ExtentTest test =  extent.createTest("MyFirstTest","sample ");
//		test.log(Status.INFO, "This is a logging event for MyFirstTest, and it passed!");
		
		LoginPage lg = new LoginPage(driver);
		lg.setUsername(username);	
		logger.info("Username Entered");
//		test.log(Status.INFO, "Username_Name_Entered");
		
		
		lg.setPassword(password);
		logger.info("Password Entered");
		lg.clickSubmit();
//		test.log(Status.INFO, "Password_Entered");
		
		logger.info("Login Successfull");
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
//		test.log(Status.INFO, "Login_Successful");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
//			System.out.println("BhalaHelani");
			Assert.assertTrue(true);
//			test.log(Status.INFO, "We at Homepage");
			logger.info("Test Case Pass");
			
		} else {
//			System.out.println("BhalaHela");
//			test.fail("fail");
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Test Case Fail");
//			test.log(Status.FAIL, "It is failed");
//			test.fail(MediaEntityBuilder.createScreenCaptureFromPath("./Fail/img.png").build());
//			test.addScreenCaptureFromPath("extent.png");
		}
	}
}
