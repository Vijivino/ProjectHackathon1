package com.frasershospitality.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy (xpath="//a[text()='member sign up']")
	WebElement memberSignUp;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickMemberSignup() throws InterruptedException {
		memberSignUp.click();
		Thread.sleep(3000);
	}
	
}
