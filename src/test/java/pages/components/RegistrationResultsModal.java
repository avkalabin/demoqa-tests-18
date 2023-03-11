package pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {
    public RegistrationResultsModal verifyResultsModalAppears() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationResultsModal verifyResultsModalData(String labelText, String valuesText) {
        $(".table-responsive").$(byText(labelText)).parent().shouldHave((text(valuesText)));
        return this;
    }

}
