package steps;

import io.cucumber.java.en.When;
import static com.codeborne.selenide.Selenide.open;

public class TestStep {

    @When("Test")
    public void test() {
        open("https://www.google.com/?client=safari");
    }
}
