import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.util.Date;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov@email.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("8800555555");
        $("#dateOfBirthInput").setValue("11 Jan 1989");
        $("#subjectsInput").setValue("English").pressEnter().setValue("Computer Science").pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("file.png");
        $("#currentAddress").setValue("some address");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
       // $("#submit").click();
        //$("#output").shouldHave(text("Ivan Petrov"),text("ivanpetrov@ya.ru"),
       //         text("some address"),text("anotherAddress"));


    }
}
