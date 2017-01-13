package com.cts.classcode;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseCode {
	
	public WebDriver driver;
	public WebDriverWait wdw;
	private void launchBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver", "D:\\SeleniumClasses\\BrowserDrivers\\geckodriver-v0.10.0-win64\\geckodriver.exe"); 
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
	Select sel;
	
	public void launchApplication(String url, String browserName) {
		this.launchBrowser(browserName);
		//implicit wait
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(url);
		System.out.println("Launching Applicaiton");
		driver.manage().window().maximize();
		wdw= new WebDriverWait(driver,20);
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
	
	public void selectValuesfromDropDown (WebElement element, String Text, int flag  ) {
		sel = new Select(element);
			if(flag==1){
			sel.selectByVisibleText(Text);
			}
			else {
				sel.selectByValue(Text);
			}
	}
	
	public void selectValuesfromDropDown (WebElement element, int ind  ) {
		sel = new Select(element);
		sel.selectByIndex(ind);
	}
	
	public void waitForLoading(){
		WebElement loader =driver.findElement(By.xpath(".//*[@id='loading']/img"));
		
		wdw.until(ExpectedConditions.visibilityOf(loader));
	}
	
}
