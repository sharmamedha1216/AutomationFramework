package SeleniumFW.SeleniumFW;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions (
		features = "D:\\SeleniumClasses\\SeleniumFW\\src\\test\\java\\Feature",
		glue = "StepDefinition"
		
		)
public class App 
{
   
}
