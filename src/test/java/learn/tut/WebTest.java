package learn.tut;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class WebTest {

    @Test
    public void checkWeb(){
        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.firefox().launch();
            Page page = browser.newPage();
            page.navigate("http://www.example.com");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/resources/playwright_capture.png")).setFullPage(true));
            System.out.println(page.url());
            System.out.println(page.title());
        }
    }

}
