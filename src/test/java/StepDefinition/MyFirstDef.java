package StepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;


class WhatIsToday {
    public boolean isTodayFriday(String actualDay, String today) {
        return today.equals(actualDay);

    }
}

@RunWith(Cucumber.class)
@CucumberOptions
public class MyFirstDef {
    private String today;
    private String actualAnswer;
    private WhatIsToday whatIsToday;


    @Given("Today is Sunday")
    public void today_is_sunday() {
        // Write code here that turns the phrase above into concrete actions
        today = "friday";
    }

    @When("I ask whether it's Friday Yet?")
    public void i_ask_whether_it_s_friday_yet() {
        // Write code here that turns the phrase above into concrete actions
        actualAnswer = "friday";
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String arg0) {
        System.out.println(arg0);
        whatIsToday = new WhatIsToday();
        // Write code here that turns the phrase above into concrete actions
        whatIsToday.isTodayFriday(today, actualAnswer);

    }




}
