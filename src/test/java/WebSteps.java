import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage () {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchRepository (String repository) {
        $(".header-search-button").click();
        $("#query-builder-test").setValue(repository).pressEnter();
    }

    @Step("Переходим в репозиторий")
    public void goToRepository() {
        $("[href='/arane1223/QAGURU-JUnit-HW8']").click();
    }

    @Step("Проверяем в репозитории наличие вкладки Issues")
    public void shouldSeeIssues(String value) {
        $("#issues-tab").shouldHave(text(value));
    }

}
