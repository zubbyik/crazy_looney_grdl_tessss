package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItsFriday{
    public static String isItFriday(String today) {
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }

}


public class ShouldBeFriday {
    private String today;
    private String actualAnswer;

    @Given("Today is {string}")
    public void today_is(String today) {
        this.today = today;
    }

    @When("I ask whether it is Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = ItsFriday.isItFriday(today);
    }

    @Then("I should then be told the {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

}
