import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    void successfulFindingIssueInRepositoryWithSelenideTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $(".header-search-button").click();
        $("#query-builder-test").setValue("arane1223/QAGURU-JUnit-HW8").pressEnter();
        $("[href='/arane1223/QAGURU-JUnit-HW8']").click();
        $("#issues-tab").shouldHave(text("Issues"));
    }
}