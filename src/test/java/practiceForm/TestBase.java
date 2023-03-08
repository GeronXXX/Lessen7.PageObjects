package practiceForm;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pages.TestData;

public class TestBase {
    TestData testData = new TestData();
    @AfterAll
    static void after() {
        Configuration.holdBrowserOpen = true;
    }

    @BeforeAll
    static void beforeALL() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
