package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final CalendarComponent calendarComponent = new CalendarComponent();

    private final SelenideElement FIRST_NAME_INPUT = $("#firstName"),
            LAST_NAME_INPUT = $("#lastName"),
            EMAIL_INPUT = $("#userEmail"),
            GENDER_INPUT = $("#genterWrapper"),
            PHONE_NUMBER_INPUT = $("#userNumber"),
            DATE_OF_BIRTH_INPUT = $("#dateOfBirthInput"),
            SUBJECT_INPUT = $("#subjectsInput"),
            HOBBIES_INPUT = $("#hobbiesWrapper"),
            UPLOAD_PICTURE_INPUT = $("#uploadPicture"),
            CURRENT_ADDRESS_INPUT = $("#currentAddress"),
            STATE_INPUT = $("#react-select-3-input"),
            CITY_INPUT = $("#react-select-4-input"),
            SUBMIT_BUTTON = $("#submit");

    @Step("Открываем форму регистрации")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    @Step("Удаляем баннеры")
    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Вводим имя: {value}")
    public RegistrationPage setFirstName(String value) {
        FIRST_NAME_INPUT.setValue(value);
        return this;
    }

    @Step("Вводим фамилию: {value}")
    public RegistrationPage setLastName(String value) {
        LAST_NAME_INPUT.setValue(value);
        return this;
    }

    @Step("Вводим email: {value}")
    public RegistrationPage setEmail(String value) {
        EMAIL_INPUT.setValue(value);
        return this;
    }

    @Step("Вводим номер телефона: {value}")
    public RegistrationPage setPhoneNumber(String value) {
        PHONE_NUMBER_INPUT.setValue(value);
        return this;
    }

    @Step("Выбираем пол: {value}")
    public RegistrationPage setGender(String value) {
        GENDER_INPUT.$(byText(value)).click();
        return this;
    }

    @Step("Вводим предмет: {value}")
    public RegistrationPage setSubject(String value) {
        SUBJECT_INPUT.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбираем хобби: {value}")
    public RegistrationPage setHobbies(String value) {
        HOBBIES_INPUT.$(byText(value)).click();
        return this;
    }

    @Step("Загружаем фото: {value}")
    public RegistrationPage uploadPicture(String value) {
        UPLOAD_PICTURE_INPUT.uploadFromClasspath(value);
        return this;
    }

    @Step("Вводим адрес: {value}")
    public RegistrationPage setCurrentAddress(String value) {
        CURRENT_ADDRESS_INPUT.setValue(value);
        return this;
    }

    @Step("Выбираем штат: {value}")
    public RegistrationPage selectState(String value) {
        STATE_INPUT.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбираем город: {value}")
    public RegistrationPage selectCity(String value) {
        CITY_INPUT.setValue(value).pressEnter();
        return this;
    }

    @Step("Нажимаем кнопку подтверждения")
    public RegistrationPage submitButtonClick() {
        SUBMIT_BUTTON.click();
        return this;
    }

    @Step("Заполняем дату рождения: {dayOfBirth} {monthOfBirth} {yearOfBirth}")
    public RegistrationPage setBirthDate(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        DATE_OF_BIRTH_INPUT.click();
        calendarComponent.setDate(dayOfBirth, monthOfBirth, yearOfBirth);
        return this;
    }

}
