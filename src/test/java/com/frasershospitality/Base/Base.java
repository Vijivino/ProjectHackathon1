package com.frasershospitality.Base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	
	
	public Base(){

		prop=new Properties();
		try {
		FileInputStream fis=new FileInputStream("C:\\Users\\vijayalaxmi.rajaa\\SampleTesting\\ProjectHackathon\\src\\test\\java\\com\\frasershospitality\\config\\config.properties");
		prop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public WebDriver launch() {
		
	/*	ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("autofill.profile_enabled", false);
		options.addArguments("--disable-web-security");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-notifications");
		//options.setCapability("autofill.profile_enabled", false);
		//    ( options).AAddUserProfilePreferences("autofill.profile_enabled",false);
		options.setExperimentalOption("prefs", prefs);
		driver= new ChromeDriver(options);
*/		
	    driver = new ChromeDriver();
		driver.get("https://www.frasershospitality.com/en/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		return driver;
		
	}
	



}
