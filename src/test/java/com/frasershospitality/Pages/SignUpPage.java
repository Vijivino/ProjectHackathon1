package com.frasershospitality.Pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
	
WebDriver driver;
JavascriptExecutor js;
	
	@FindBy (id="salutation")
	WebElement salutationDropdown;
	@FindBy (id="firstname")
	WebElement firstName;
	@FindBy (id="lastname")
	WebElement lastName;
	@FindBy (id="dob")
	WebElement DOB;
	@FindBy (xpath="//span[text()='Please select']")
	WebElement country;
	@FindBy (xpath="//input[@class='select2-search__field']")
	WebElement searchfield;
	@FindBy(xpath="//li[text()='India']")
	WebElement selname;
	@FindBy(id="source")
	WebElement source;
	@FindBy(id="email")
	WebElement email;
	@FindBy(id="passwordd")
	WebElement password;
	@FindBy(id="confirmpass")
	WebElement confirmpw;
	@FindBy(css =" #label[for='terms']::before")
	WebElement termscheckbox;
	@FindBy(xpath="//div[@class='services__title']")
	List<WebElement> logoelementlist;
	@FindBy (xpath="//iframe[@title='reCAPTCHA']")
	WebElement captchaFrame;
	@FindBy (xpath="//div[@role='presentation']")
	WebElement captchaCheckbox;
	
	
	public  SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		js= (JavascriptExecutor) driver;
	}
	
	public void selectSalutation(String salute) {
		
		//js.executeScript("window.scrollBy(0,250)");
		js.executeScript("arguments[0].scrollIntoView(true);", salutationDropdown);
		Select sel=new Select(salutationDropdown);
		sel.selectByVisibleText(salute);
			
	}
	
	public void enterName(String Fname,String Lname) {
		firstName.sendKeys(Fname);
		lastName.sendKeys(Lname);
	}
	
	public void enterDOB(String dob) throws IOException {
		
		//js.executeScript("arguments[0].value='03/19/1994'", DOB);
		DOB.sendKeys(dob);
		
		File source=((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\vijayalaxmi.rajaa\\SampleTesting\\ProjectHackathon\\Screenshots\\snap.png");
		FileUtils.copyFile(source, destination);
		}
	
	public void selectCountry(String countryname) throws InterruptedException {
		
		country.click();
		searchfield.sendKeys(countryname);
		selname.click();
	}
	
	public void selectSource(String sourcename) {
		Select sel=new Select(source);
		sel.selectByVisibleText(sourcename);
	}
	
	public void enterLoginDetails(String Email,String pw,String confirmPW) throws IOException {
		
		js.executeScript("arguments[0].scrollIntoView(true);", email);
		email.sendKeys(Email);
		
		password.sendKeys(pw);
		confirmpw.sendKeys(confirmPW);
		String attribute = email.getAttribute("value");
		System.out.println(attribute);
		File source1=((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
		File destination1=new File("C:\\Users\\vijayalaxmi.rajaa\\SampleTesting\\ProjectHackathon\\Screenshots\\snap1.png");
		FileUtils.copyFile(source1, destination1);
		
		
	}
	
	public String validateName() {
		String attribute = email.getAttribute("value");
		return attribute;
		
	}
	
	public void clickCheckBox() {
		
		//termscheckbox.click();
		//parenttagname#anyattributevalue
		js.executeScript("document.querySelector('input#terms').click();");
		js.executeScript("document.querySelector('input#marketingConsent').click();");
		
		//(input#terms)
	}
	
	public void clickCpatcha() throws InterruptedException {
		
		
		driver.switchTo().frame(captchaFrame);
		//captchaCheckbox.click();
		js.executeScript("arguments[0].click()", captchaCheckbox);
		
	}
	
	public void writeData() throws InterruptedException, IOException {
		

		Thread.sleep(3000);
		  
        FileOutputStream ExcelFile = new FileOutputStream(
                new File("C:\\Users\\vijayalaxmi.rajaa\\SampleTesting\\ProjectHackathon\\src\\test\\resources\\Capturelogo.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("LogoElements");
		
		//creating header
		int rowid=0;
		sheet.createRow(rowid++).createCell(0).setCellValue("TEXT OF THE LOGO ELEMENTS");
		//configuring the cellstyle
		//CellStyle style=cell1.getSheet().getWorkbook().createCellStyle();
		
		for(int i=0;i<logoelementlist.size();i++) {
			sheet.createRow(rowid++).createCell(0).setCellValue(logoelementlist.get(i).getText());
			System.out.println(logoelementlist.get(i).getText());
	}
		workbook.write(ExcelFile);
		workbook.close();
	
	
	}
	
	

}
