package guru.qa.homework.tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import guru.qa.homework.pages.PyePage;
import guru.qa.homework.pages.VicePage;
import guru.qa.homework.pages.WebFormRegistrationPage;
import guru.qa.homework.pages.components.Calendar;
import guru.qa.homework.pages.LiarsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
public class TestBase {
    WebFormRegistrationPage registrationPage = new WebFormRegistrationPage();
    VicePage vicePage = new VicePage();
    LiarsPage liarsPage = new LiarsPage();
    PyePage pyePage = new PyePage();
    Calendar calendar = new Calendar();
    @BeforeAll
    static void setConfiguration(){
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.holdBrowserOpen = true;
    }
    @AfterEach
    public void closeBrowserAfterEachTest(){
        Selenide.closeWebDriver();
    }
}
