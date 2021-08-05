package learn.tut;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestFixtures {
    Playwright playwright;
    Browser browser;

    // New instance for each test method.
    BrowserContext context;
    Page page;

    @BeforeAll
    void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    void closeBrowser() {
        playwright.close();
    }



    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }
}

class Test1 extends TestFixtures {
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

class Test2 extends TestFixtures {
    @Test
    void shouldReturnInnerHTML() {
        page.setContent("<div>hello</div>");
        assertEquals("hello", page.innerHTML("css=div"));
    }

    @Test
    void shouldClickButton() {
        Page popup = page.waitForPopup(() -> {
            page.evaluate("window.open('about:blank');");
        });
        assertEquals("about:blank", popup.url());
    }
}
