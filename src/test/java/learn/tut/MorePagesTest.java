/**
 *
 * @Author Ikemefuna Egbuna
 *
 */


package learn.tut;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type More pages test.
 */
public class MorePagesTest {
    private static Page page;
    private static Page page_mobile;
    private static BrowserContext context;
    private static BrowserContext context_mobile;
    private static BrowserType chromium;
    private static List<ElementHandle> menu_links;


    /**
     * Initialize playwright.
     */
    @BeforeEach
    public void initializePlaywright() {
        Playwright playwright = Playwright.create();
        chromium = playwright.chromium();

    }

    /**
     * Check dashboard.
     */
    /*
    @Test
    @Tag("desktop")
    void checkDashboard() {
        context = chromium.launch().newContext();
        page = context.newPage();
        String pass = System.getProperty("webtest.pass");
        page.navigate("http://192.168.43.227");
        assertEquals("http://192.168.43.227/symfony/web/index.php/auth/login", page.url());
        page.fill("input[name='txtUsername']", "admin");
        page.fill("input[name='txtPassword']", pass);
        page.click("input:has-text('LOGIN')");


        // --------- Dashboard Lists ----
        page.waitForLoadState();
        menu_links = page.querySelectorAll(".menu a");
        menu_links.stream()
                .forEach(x -> {
                    ElementHandle e = x.asElement();
                    e.hover();
                    page.screenshot(new Page.ScreenshotOptions()
                            .setPath(Paths.get(String.format("./src/test/screenshots/desktop/snap-%s-front.png", x.innerText())))
                            .setOmitBackground(true)
                            .setFullPage(true)
                    );
                });
    }

    /* Next stuff I need to do.
     1. Iterate the links and go through each of the links to the pages.
          a. Use the screenshot from the dashboard for direction
    2.
*/

    /*
    @Test
    @Tag("Mobile")
    void checkMobileDashboard() {
        context_mobile = chromium.launch().newContext();
        page_mobile = context_mobile.newPage();
        page_mobile.setViewportSize(640, 480);
        String pass = System.getProperty("webtest.pass");
        page_mobile.navigate("http://192.168.43.227");
        assertEquals("http://192.168.43.227/symfony/web/index.php/auth/login", page_mobile.url());
        page_mobile.fill("input[name='txtUsername']", "admin");
        page_mobile.fill("input[name='txtPassword']", pass);
        page_mobile.click("input:has-text('LOGIN')");


        // --------- Dashboard Lists ----
        page_mobile.waitForLoadState();
        List<ElementHandle> menu_links = page_mobile.querySelectorAll(".menu a");
        menu_links.stream()
                .forEach(x -> {
                    ElementHandle e = x.asElement();
                    e.hover();
                    page_mobile.screenshot(new Page.ScreenshotOptions()
                            .setPath(Paths.get(String.format("./src/test/screenshots/mobile/snap-%s-front.png", x.innerText())))
                            .setOmitBackground(true)
                            .setFullPage(true)
                    );

                });


    } */
}
