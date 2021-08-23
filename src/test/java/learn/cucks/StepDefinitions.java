package learn.cucks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
public class StepDefinitions {
    @Given("Today is Sunday")
    public void today_is_sunday() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("completed");
    }

    @When("I ask whether it's Friday Yet?")
    public void i_ask_whether_it_s_friday_yet() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("completed");
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("completed");
    }


}
