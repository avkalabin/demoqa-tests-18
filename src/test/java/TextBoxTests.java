import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("Ivan Petrov");
        $("#userEmail").setValue("ivanpetrov@ya.ru");
        $("[id=currentAddress]").setValue("some address");
        $("#permanentAddress").setValue("anotherAddress");
        $("#submit").click();
        $("#output").shouldHave(text("Ivan Petrov"),text("ivanpetrov@ya.ru"),
                text("some address"),text("anotherAddress") );


    }
}
