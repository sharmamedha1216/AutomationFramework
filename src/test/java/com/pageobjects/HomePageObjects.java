package com.pageobjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cts.classcode.BaseCode;




public class HomePageObjects extends BaseCode {

	String PageLogo =".//a[@class='voteNitiLogo']/img[@title='India votes']";
	String TabLinksbyXpath = ".//*[@id='dd_menu']/li/a";
	String LKSabhaElctnYr = ".//*[@id='year']";
	String LKSabhaElctnState = ".//*[@id='state']";
	String GoButton1 = ".//*[@id='form']/select[@id='state']/following-sibling::input[@class='searchIcon fr']";
	String LKElctnnRslt =  ".//*[@id='mianContent']/div[2]/div/div";
	String ElectoralDataXpath = ".//div[@class='searchBoxRight']/div/p";
	//or By xpathElectoralData = By.xpath(".//*[@id='mianContent']//div[@class='searchBoxRight']/div/p");

	public void verifyTabLinks(){
	String ExpectedTabList[] = {"Home","About Us","Search Filter","Election Maps","Summary Report","Blog","Report Errors"};
	
	List <WebElement> elementlist = driver.findElements(By.xpath(TabLinksbyXpath));
	int len = elementlist.size();
	System.out.println(len);
			    
		   for (int i = 0; i < len; i++) {
			   String ActualValue = elementlist.get(i).getText();
			   if(ActualValue.equalsIgnoreCase(ExpectedTabList[i])){
				   System.out.println("Tab available");
			   }
			   else {
				   System.out.println("Tab not available");
			   }
			   
		   }

	} 
	
	public void selectValuesandGo(String year, String state ) {
		
		WebElement SelectYear = driver.findElement(By.xpath(LKSabhaElctnYr));
		this.selectValuesfromDropDown(SelectYear, 1);
		
		WebElement SelectState = driver.findElement(By.xpath(LKSabhaElctnState));
		//explicit wait
		wdw.until(ExpectedConditions.textToBePresentInElement(By.xpath(LKSabhaElctnState),"Assam"));

		this.selectValuesfromDropDown(SelectState, state, 1);
			
		driver.findElement(By.xpath(GoButton1)).click();
		//this.waitForLoading();
					
		}
	
	public void verifyElectoralData(String electors, String votespolled,String turnout, String pc) {
	
	/* understand new keyword */	List <WebElement> electoralData = driver.findElements(By.xpath(ElectoralDataXpath)); //List and Set keywords serves same purpose except the duplicacy handling of sub-elements.
			for(WebElement element : electoralData ){
				String value = element.getText();
				String [] val = value.split(":");
					
					if (val[0].equalsIgnoreCase("Electors")){
					assert val[1].equalsIgnoreCase(electors);	
					System.out.println("Electors Expecetd value " + electors);
					}
					
					if (val[0].equalsIgnoreCase("Votes Polled")) {
					assert val [1].equalsIgnoreCase(votespolled);
					System.out.println("votes polled Expecetd value " + votespolled);	
					}

					if (val[0].equalsIgnoreCase("Turnout")) {
					assert val[1].equalsIgnoreCase(turnout);
					System.out.println("Turnout Expecetd value " + turnout);
					}
					
					if (val[0].equalsIgnoreCase("Parliamentary Constituencies")) { 
					assert val[1].equalsIgnoreCase(pc);
					System.out.println("PC Expecetd value " + pc);
					}
				
				
			}
		
		
		
	}

	public void switchToAnotherWindow(){
		
		
		Set <String> handles = driver.getWindowHandles();
		System.out.println(handles);
			
			for(String handle: handles) {
				driver.switchTo().window(handle);
				if(driver.getTitle().equals("Home credit")) {
					System.out.println(driver.getPageSource());
					break;
				}
				else {
					continue;
				}
			}
		
	}


}
