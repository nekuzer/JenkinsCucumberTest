package steps;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.*;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.*;

public class TestStep {

    public static WebDriver driver = new ChromeDriver();

    @Before
    public void before() {
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("---------------- ok ----------------");
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "ok");

        } else {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "not ok");
        }

    }

    @When("Test")
    public void test() {
        driver.get("https://www.google.com/?client=safari");
        $(By.xpath("//div[contains(text(), '')]")).shouldBe(Condition.visible.because("Его нет"));
        driver.close();
    }
}
