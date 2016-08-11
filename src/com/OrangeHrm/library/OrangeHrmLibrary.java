package com.OrangeHrm.library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class OrangeHrmLibrary 
{
	
public static WebDriver driver;
public String url="http://opensource.demo.orangehrmlive.com";
public String uid="Admin";
public String pwd="admin";

public String launchApp(String url)
{
	System.setProperty("webdriver.chrome.driver", "E:\\Qedge Working Folder\\Chrome driver\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(url);
	Assert.assertTrue(driver.findElement(By.id("btnLogin")).isDisplayed(), "Login button not present in login page");
if (driver.findElement(By.id("btnLogin")).isDisplayed()) 
		{
	return "Pass";
}
else
{
	return "Fail";
}
}

public String adminlogin(String uid, String pwd)
{
	driver.findElement(By.id("txtUsername")).sendKeys(uid);
	driver.findElement(By.id("txtPassword")).sendKeys(pwd);
	driver.findElement(By.id("btnLogin")).click();
	Assert.assertTrue(driver.findElement(By.linkText("Welcome Admin")).isDisplayed());
	if (driver.findElement(By.linkText("Welcome Admin")).isDisplayed())
	{
	return "Pass";
	}
	else
	{
		return "Fail";
	}
	}
}
