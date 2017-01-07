package StepDefinition;

import com.cts.classcode.BaseCode;

import cucumber.api.java.en.*;

public class Home {

	/*@Given("^I want to write a step with precondition$")
	public void i_want_to_write_a_step_with_precondition() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  System.out.println("Step 1");  
	}

	@Given("^some other precondition$")
	public void some_other_precondition() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Step 2");  
	}

	@When("^I complete action$")
	public void i_complete_action() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Step 3");
	}

	@When("^some other action$")
	public void some_other_action() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Step 4");
	}

	@When("^yet another action$")
	public void yet_another_action() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Step 5");
	}

	@Then("^I validate the outcomes$")
	public void i_validate_the_outcomes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Step 6");
	}

	@Then("^check more outcomes$")
	public void check_more_outcomes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Step 7");
	}*/
	
		BaseCode bc = new BaseCode();
	
		
	
		@Given("^Launch Applicaiton$")
		public void launch_Applicaiton() throws Throwable {
	    bc.launchApplication("http://indiavotes.com", "Chrome");
		}
		
		@Given("^Close Application$")
		public void close_Application() throws Throwable {
		bc.closeApplication("true"); 
		}



	
}
