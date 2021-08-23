package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(
        features = {"src/test/features"},
        glue = "StepDefinition",
        plugin = { "pretty", "html:target/htmlreports" }
)
@RunWith(Cucumber.class)
public class Runner {
}
