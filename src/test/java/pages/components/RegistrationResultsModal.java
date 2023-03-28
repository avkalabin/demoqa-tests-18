package pages.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {

    @Step("Проверяем появление формы с результатами")
    public RegistrationResultsModal verifyResultsModalAppears() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    @Step("Проверяем, что поле \"{labelText}\" содержит \"{valuesText}\"")
    public RegistrationResultsModal verifyResultsModalData(String labelText, String valuesText) {
        $(".table-responsive").$(byText(labelText)).parent().shouldHave((text(valuesText)));
        return this;
    }

}
