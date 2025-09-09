import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTest {

    public static final String REPOSITORY = "arane1223/QAGURU-JUnit-HW8";

    @Test
    void successfulFindingIssueInRepositoryWithLambdaTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        });

        step("Открываем репозиторий", () -> {
            $("[href='/arane1223/QAGURU-JUnit-HW8']").click();
        });

        step("Проверяем в репозитории наличие вкладки Issues", () -> {
            $("#issues-tab").shouldHave(text("Issues"));
        });
    }
}
