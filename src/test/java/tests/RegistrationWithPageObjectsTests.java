package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String email = "ivanov@email.com";
        String phoneNumber = "8800555555";
        String dayOfBirth = "27";
        String monthOfBirth = "March";
        String yearOfBirth = "1989";
        String subject = "Computer Science";
        String pictureName = "file.png";
        String currentAddress = "some address";
        String state = "NCR";
        String city = "Delhi";


        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender()
                .setHobbies()
                .setPhoneNumber(phoneNumber)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .uploadPicture(pictureName)
                .setCurrentAddress(currentAddress)
                .selectState(state)
                .selectCity(city)
                .submitButtonClick();


        registrationPage.verifyResultsModalAppears()
                .verifyResultsModalData("Student Name", firstName + " " + lastName)
                .verifyResultsModalData("Student Email", email)
                .verifyResultsModalData("Gender", "Male")
                .verifyResultsModalData("Mobile", phoneNumber)
                .verifyResultsModalData("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .verifyResultsModalData("Subjects", subject)
                .verifyResultsModalData("Hobbies", "Sports")
                .verifyResultsModalData("Picture", pictureName)
                .verifyResultsModalData("Address", currentAddress)
                .verifyResultsModalData("State and City", state + " " + city);

    }
}
