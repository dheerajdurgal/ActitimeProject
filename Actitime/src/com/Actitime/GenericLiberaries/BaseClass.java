package com.Actitime.GenericLiberaries;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	public static WebDriver driver;
	FileLiberary f = new FileLiberary();//here we create object for "FileLiberary" because to called the non-static method(readdatafromproperty)and make it as global to called the mathod anywhere 
@BeforeSuite
public void databaseconnection() {
	Reporter.log("Database connected Successfully",true);
}
@AfterSuite
public void databasedisconnection() {
	Reporter.log("database disconnected successfully",true);
}
@BeforeClass
  public void LaunchBrowser() throws IOException {
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	driver = new ChromeDriver(option);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	String URL = f.readdatafromproperty("url");
	driver.get(URL);
	Reporter.log("browser launched",true);
}
@AfterClass
public void CloseBrowser() {
	driver.close();
	Reporter.log("browser closed",true);
}
@BeforeMethod
public void Login() throws IOException {
	String UN = f.readdatafromproperty("username");//called non-static method
	String PW = f.readdatafromproperty("password");//called non-static method
	driver.findElement(By.id("username")).sendKeys(UN);//enter parameter
	driver.findElement(By.name("pwd")).sendKeys(PW);//enter parameter
	driver.findElement(By.xpath("//div[text()='Login ']")).click();
	Reporter.log("Login successfully");
}
@AfterMethod
public void Logout() {
	driver.findElement(By.id("logoutLink")).click();
	Reporter.log("Logout Successfuly");
}

}
