package steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestStep {

    @When("Test")
    public void test() {
        open("https://www.google.com/?client=safari");
        $(By.xpath("//div[contains(text(), 'sfesfesfsefsef')]")).shouldBe(Condition.visible.because("Его нет"));
    }
}
