package learn.tut;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The type Web 2 test.
 */
public class Web2Test {
    /**
     * The Playwright.
     */
    static Playwright playwright;
    /**
     * The Browser.
     */
    static Browser browser;
    /**
     * The Page.
     */
    static Page page;
    /**
     * The Context.
     */
    static BrowserContext context;


    /**
     * Setup.
     */
    @BeforeAll
    public static void setup(){
        playwright = Playwright.create();
        browser = playwright.firefox().launch();
    }


    /**
     * Tear down.
     */
    @AfterAll
    public static void tearDown(){
        browser.close();
    }

    /**
     * Set context.
     */
    @BeforeEach
    public void setContext(){
        context = browser.newContext();
        page = browser.newPage();
    }


    /**
     * Close context.
     */
    @AfterEach
    public void  closeContext(){
        context.close();
    }

    /**
     * Should click button.
     */
    @Test
    void shouldClickButton() {
        page.navigate("data:text/html,<script>var result;</script><button onclick='result=\"Clicked\"'>Go</button>");
        page.click("button");
        assertEquals("Clicked", page.evaluate("result"));
    }

    /**
     * Should check the box.
     */
    @Test
    void shouldCheckTheBox() {
        page.setContent("<input id='checkbox' type='checkbox'></input>");
        page.check("input");
        assertTrue((Boolean) page.evaluate("() => window['checkbox'].checked"));
    }

    /**
     * Should search wiki.
     */
    @Test
    void shouldSearchWiki() {
        page.navigate("https://www.wikipedia.org/");
        page.click("input[name=\"search\"]");
        page.fill("input[name=\"search\"]", "playwright");
        page.press("input[name=\"search\"]", "Enter");
        assertEquals("https://en.wikipedia.org/wiki/Playwright", page.url());
    }

    /**
     * Apirequests.
     */
    @Test
    void apirequests(){
        page.onRequest(Request::url);
    }
}
