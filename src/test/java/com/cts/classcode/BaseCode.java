package com.cts.classcode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseCode {
	
	WebDriver driver;
	private void launchBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver", "D:\\Software\\geckodriver-v0.10.0-win64\\geckodriver.exe"); 
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\SeleniumClasses\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe"); // Chrome Driver to be downloaded and path is to be changed accordingly
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "D:\\SeleniumClasses\\BrowserDrivers\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe"); // IE Driver to be downloaded and path is to be changed accordingly
			driver = new InternetExplorerDriver();
			
		}
		else {
			System.out.println("Incorrect Browser Name");
		}
	}
	
	public void launchApplication(String url, String browserName) {
		this.launchBrowser(browserName);
		driver.get(url);
		System.out.println("Launching Applicaiton");
		driver.manage().window().maximize();
	}
	
	public void closeApplication(String flag) {
		
		System.out.println("Closing Applicaiton");
		if(flag.equalsIgnoreCase("true")){
			driver.close();
		}
		else {
			driver.quit();
		}
	}
}
