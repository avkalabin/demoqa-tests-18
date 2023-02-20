import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

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
        $("#subjectsInput").setValue("English").pressEnter().setValue("Computer Science").pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("file.png");
        $("#currentAddress").setValue("some address");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        executeJavaScript("$('[id = dateOfBirthInput]').val('11 Jan 2000')");
        $("#submit").click();
        $(".table-responsive").shouldHave(text("Ivan Ivanov"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("file.png"));


    }
}
