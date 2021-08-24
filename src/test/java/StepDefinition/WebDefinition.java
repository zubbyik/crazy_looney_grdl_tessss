package StepDefinition;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebDefinition {
    Playwright playwright = Playwright.create();
    BrowserType browserType = playwright.firefox();
    BrowserContext context = browserType.launch().newContext();
    Page page = context.newPage();


    @Given("I am on the Google search page")
    public void i_am_on_the_google_search_page() {
        page.navigate("https://www.google.com");
    }

    @When("I search for {string}")
    public void i_search_for(String searchItem) {
        page.fill("[aria-label=\"Search\"]", searchItem);
        // Press Enter
        // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://www.google.com/search?q=cheese&source=hp&ei=SMMkYfDNBf7V1sQProePkAg&iflsig=AINFCbYAAAAAYSTRWNJo4DSWPpIh4EDjcq5F7I_YLecw&oq=cheese&gs_lcp=Cgdnd3Mtd2l6EAMyCwguEIAEELEDEJMCMgUILhCABDIFCC4QgAQyCAguEIAEELEDMgUILhCABDIFCC4QgAQyBQgAEIAEMgUIABCABDILCC4QgAQQxwEQowIyBQgAEIAEOggIABDqAhCPAToICC4Q6gIQjwE6CAgAEIAEELEDOgUIABCxAzoLCAAQgAQQsQMQgwFQpfkBWJ2OAmD2zwJoAXAAeACAAfABiAGhCpIBBTAuMi40mAEAoAEBsAEK&sclient=gws-wiz&ved=0ahUKEwjwkYums8nyAhX-qpUCHa7DA4IQ4dUDCAc&uact=5"), () ->
        page.waitForNavigation(() -> {
            page.press("[aria-label=\"Search\"]", "Enter");
        });
    }

    @Then("the page title should start with cheese")
    public void the_page_title_should_start_with_cheese() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(page.title().startsWith("Cheese"));
    }

    @After
    public void ifFails(Scenario scenario){
        if(scenario.isFailed()){
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/resources/if_googlefails.png")));
        }
    }

}
