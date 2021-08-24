package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyShoppingList {
    @Given("I am in {string}")
    public void i_am_in(String town) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When I am in "+ town);
    }

    @When("I go to the Marks and Spencer")
    public void i_go_to_the_marks_and_spencer() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When I go to Marks and Spencer");
    }

    @Then("I am expected to buy {string}")
    public void i_am_expected_to_buy(String item) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(item);
    }
}
