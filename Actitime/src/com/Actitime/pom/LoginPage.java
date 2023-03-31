package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//DECLARATION
	@FindBy(id="username")
	private WebElement UNTF;
	
	@FindBy(name="pwd")
	private WebElement PWTF;
	
	@FindBy(xpath ="//div[.='Login ']")
	private WebElement Loginbtn;
	
	//INITIALIZATION
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//UTILIZATION

	public WebElement getUNTF() {  //to called getters and setters method direcrty follow below steps:-
		return UNTF;                // go to source-->click on generate getters and setters-->click on select getters if we want Getter method
	}                               //--> click on select setters if we want setter method

	public WebElement getPWTF() {
		return PWTF;
	}

	public WebElement getLoginbtn() {
		return Loginbtn;
	}
}

