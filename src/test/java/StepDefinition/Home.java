package StepDefinition;

import com.pageobjects.HomePageObjects;
import cucumber.api.java.en.*;

public class Home{

		
		HomePageObjects bc = new HomePageObjects();
	
		@When("^User Launch Applicaiton$")
		public void launch_Applicaiton() {
	    bc.launchApplication("http://indiavotes.com", "ie");
		}
		
		@And ("^verify all tabs in home page$")
		public void verify_all_tabs_in_home_page()  {
		bc.verifyTabLinks();
		}
		
		@Then("^Close Application$")
		public void close_Application() {
		bc.closeApplication("true"); 
		}

				
		@Then("^Verify the Results for selected Year \"([^\"]*)\" and state \"([^\"]*)\"$")
		public void verify_the_Results_for_selected_Year_and_state(String arg1, String arg2) {
		bc.selectValuesandGo(arg1, arg2);  
		}
		
		
		@Then("^Verify Values \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
		public void verify_Values_and_and_and(String arg1, String arg2, String arg3, String arg4)  {
		bc.verifyElectoralData(arg1, arg2, arg3, arg4);
		}
		
}
