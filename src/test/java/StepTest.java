import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class StepTest {

    private static final String ISSUES = "Issues";

    @Test
    void successfulFindingIssueInRepositoryWithStepsTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchRepository(LambdaTest.REPOSITORY);
        steps.goToRepository();
        steps.shouldSeeIssues(ISSUES);
    }
}
