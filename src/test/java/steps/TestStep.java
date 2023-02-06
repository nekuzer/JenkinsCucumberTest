package steps;

import com.codeborne.selenide.*;
import io.cucumber.java.*;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Base64;

import static com.codeborne.selenide.Selenide.*;

public class TestStep {

//    public static WebDriver driver = new ChromeDriver();

    @Before
    public void before() {
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("---------------- ok ----------------");
            byte[] decoded = Selenide.screenshot(OutputType.BYTES);
            scenario.attach(decoded, "image/png", "ok");
        } else  {
            System.out.println("---------------- error ----------------");
            byte[] decoded = Selenide.screenshot(OutputType.BYTES);
            scenario.attach(decoded, "image/png", "ok");
        }

    }

    @When("Test")
    public void test() {
        open("https://www.google.com/?client=safari");
        $(By.xpath("//div[contains(text(), 'ddaawd')]")).shouldBe(Condition.visible.because("Его нет"));
    }

    @When("Test2")
    public void test2() {
        open("https://www.google.com/?client=safari");
        $(By.xpath("//div[contains(text(), '')]")).shouldBe(Condition.visible.because("Его нет"));
    }
}
