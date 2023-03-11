package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationResultsModal;

import static tests.FakerTestData.*;


public class RegistrationWithFakerTests extends TestBase {
    private final RegistrationPage registrationPage = new RegistrationPage();
    private final RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setHobbies(hobbies)
                .setPhoneNumber(phoneNumber)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .uploadPicture(pictureName)
                .setCurrentAddress(currentAddress)
                .selectState(state)
                .selectCity(city)
                .submitButtonClick();


        registrationResultsModal.verifyResultsModalAppears()
                .verifyResultsModalData("Student Name", firstName + " " + lastName)
                .verifyResultsModalData("Student Email", email)
                .verifyResultsModalData("Gender", gender)
                .verifyResultsModalData("Mobile", phoneNumber)
                .verifyResultsModalData("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .verifyResultsModalData("Subjects", subject)
                .verifyResultsModalData("Hobbies", hobbies)
                .verifyResultsModalData("Picture", pictureName)
                .verifyResultsModalData("Address", currentAddress)
                .verifyResultsModalData("State and City", state + " " + city);
    }
}
