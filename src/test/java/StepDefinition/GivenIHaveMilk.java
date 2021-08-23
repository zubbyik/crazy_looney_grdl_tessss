package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GivenIHaveMilk {

    @Given("I am out shopping")
    public void i_am_out_shopping() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I am out shopping");
    }

    @Given("I have eggs")
    public void i_have_eggs() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I have Eggs");
    }

    @Given("I have milk")
    public void i_have_milk() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I have Milk");
    }

    @Given("I have butter")
    public void i_have_butter() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I have Butter");
    }

    @When("I check my list")
    public void i_check_my_list() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I check my lists");
    }

    @Then("I don't need anything")
    public void i_don_t_need_anything() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I dont need anything");
    }

}
