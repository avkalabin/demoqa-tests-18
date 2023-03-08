package pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    public static Faker faker = new Faker();
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

    public static String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    public static String[] subjects = {"Accounting", "Maths", "Arts", "English", "Physics", "Chemistry",
            "Computer Science", "Economics", "Social Studies", "History", "Civics", "Commerce", "Hindi", "Biology"};
    public static String[] hobbiess = {"Reading", "Sports", "Music"};

    public static String[] cities = {"Delhi", "Gurgaon", "Noida"};


    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        FIRST_NAME_INPUT.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        LAST_NAME_INPUT.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        EMAIL_INPUT.setValue(value);
        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        PHONE_NUMBER_INPUT.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        GENDER_INPUT.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setSubject(String value) {
        SUBJECT_INPUT.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        HOBBIES_INPUT.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        UPLOAD_PICTURE_INPUT.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        CURRENT_ADDRESS_INPUT.setValue(value);
        return this;
    }

    public RegistrationPage selectState(String value) {
        STATE_INPUT.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage selectCity(String value) {
        CITY_INPUT.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage submitButtonClick() {
        SUBMIT_BUTTON.click();
        return this;
    }

    public RegistrationPage setBirthDate(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        DATE_OF_BIRTH_INPUT.click();
        calendarComponent.setDate(dayOfBirth, monthOfBirth, yearOfBirth);
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResultsModalData(String labelText, String valuesText) {
        registrationResultsModal.isResultFormElementPresent(labelText, valuesText);
        return this;
    }

}
