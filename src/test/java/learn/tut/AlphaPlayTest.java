package learn.tut;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class AlphaPlayTest {


    @Test
public void testMe() throws InterruptedException {
    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch();
    Page page = browser.newContext().newPage();
    page.navigate("https://demoqa.com/alerts");

    page.onDialog(handler -> {
        System.out.printf("\nThe message displayed is %s", handler.message());
        handler.dismiss();
    });
        page.click("#alertButton");
        page.click("#timerAlertButton");
        page.click("#confirmButton");
        page.click("#promtButton");





    }




}
