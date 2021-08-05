package learn.tut;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Web2Test {
    static Playwright playwright;
    static Browser browser;
    static Page page;
    static BrowserContext context;


    @BeforeAll
    public static void setup(){
        playwright = Playwright.create();
        browser = playwright.firefox().launch();
    }


    @AfterAll
    public static void tearDown(){
        browser.close();
    }

    @BeforeEach
    public void setContext(){
        context = browser.newContext();
        page = browser.newPage();
    }


    @AfterEach
    public void  closeContext(){
        context.close();
    }

    @Test
    void shouldClickButton() {
        page.navigate("data:text/html,<script>var result;</script><button onclick='result=\"Clicked\"'>Go</button>");
        page.click("button");
        assertEquals("Clicked", page.evaluate("result"));
    }

    @Test
    void shouldCheckTheBox() {
        page.setContent("<input id='checkbox' type='checkbox'></input>");
        page.check("input");
        assertTrue((Boolean) page.evaluate("() => window['checkbox'].checked"));
    }

    @Test
    void shouldSearchWiki() {
        page.navigate("https://www.wikipedia.org/");
        page.click("input[name=\"search\"]");
        page.fill("input[name=\"search\"]", "playwright");
        page.press("input[name=\"search\"]", "Enter");
        assertEquals("https://en.wikipedia.org/wiki/Playwright", page.url());
    }
}
