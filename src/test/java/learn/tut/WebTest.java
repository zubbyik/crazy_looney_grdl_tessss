package learn.tut;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class WebTest {

    @Test
    public void checkWeb(){
        String url = System.getProperty("webtest.url");
        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.firefox().launch();
            Page page = browser.newPage();
            page.navigate(url);
            System.out.println(page.url());
            System.out.println(page.title());
        }
    }

}
