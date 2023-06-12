package com.frasershospitality.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.frasershospitality.Base.Base;
import com.frasershospitality.Pages.HomePage;
import com.frasershospitality.Pages.SignUpPage;
import com.frasershospitality.Utils.ExtentReporter;

public class SignUpTest extends Base{

	WebDriver driver;
	HomePage home;
	SignUpPage sign;
	
	public SignUpTest() {
		super();
	}
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports report;
	ExtentTest test;

	@BeforeTest
	public void beforetest() throws IOException {

		//String timeStamp = new SimpleDateFormat("dd.MM.yyy-HH.mm.ss").format(new Date());
		//htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/signup"+timeStamp+".html");
		//report=new ExtentReports();
		report=ExtentReporter.generateReport();
		report.attachReporter(htmlReporter);
		test = report.createTest("SignUpTest Test report started");

	}
	
	@Test
	public void signUp() throws InterruptedException, IOException {
		
		driver=launch();
		home=new HomePage(driver);
		home.clickMemberSignup();
		sign=new SignUpPage(driver);
		sign.selectSalutation(prop.getProperty("salutation"));
		sign.enterName(prop.getProperty("firstname"), prop.getProperty("lastname"));
		sign.enterDOB(prop.getProperty("dob"));
		test.log(Status.PASS, "Name entered successfully from properties file");
	    test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\vijayalaxmi.rajaa\\SampleTesting\\ProjectHackathon\\Screenshots\\snap.png").build());
	    sign.selectCountry(prop.getProperty("country"));
		sign.selectSource(prop.getProperty("source"));
		sign.enterLoginDetails(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("confirmpass"));
		
		Assert.assertEquals(sign.validateName(), prop.getProperty("email"));
		test.log(Status.PASS, "login details verified successfully from properties file");
		test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\vijayalaxmi.rajaa\\SampleTesting\\ProjectHackathon\\Screenshots\\snap1.png").build());
		sign.clickCheckBox();
		sign.clickCpatcha();
		
		}
	
	@Test(priority=2)
	public void EmbedDataToExcel() throws InterruptedException, IOException {
		
		driver=launch();
		home=new HomePage(driver);
		home.clickMemberSignup();
		sign=new SignUpPage(driver);
		sign.writeData();
		test.log(Status.PASS, "Logo elements Entered in excel succesfully");
		
		
	}
	
	@AfterMethod
	public void close() {
		
		report.flush();
		//driver.quit();
	}
	
	
}
