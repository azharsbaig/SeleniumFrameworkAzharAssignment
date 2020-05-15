package com.generic.code;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.BaseConfig;
import com.page.object.model.LoginPage;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;




public class BaseLogin {
//
		public static void getLogin() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		WebDriver driver = new ChromeDriver();
				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(BaseConfig.getconfig("URL"));
		
		LoginPage logins = new LoginPage(driver);
		System.out.println(driver.getTitle());
		//logins.getacceptcookies().click();
				
		System.out.println(driver.getCurrentUrl());
				
		logins.getacceptcookies().click();
				
		new Highlighter().getcolor(driver, logins.signin());
		Thread.sleep(3000);
		logins.signin().click();
				
		Wait.getExplicitWaitClicable(driver, logins.getEmail());
		new Highlighter().getcolor(driver, logins.getEmail());
		
		logins.getEmail().sendKeys(BaseConfig.getconfig("email"));;
		
		
		new Highlighter().getcolor(driver, logins.getPass());
		logins.getPass().sendKeys(BaseConfig.getconfig("pass"));
		Thread.sleep(5000);
				
		new Highlighter().getcolor(driver, logins.getSubmit());
		logins.getSubmit().click();
		Thread.sleep(5000);
		
		driver.quit();		
		
	}
}
