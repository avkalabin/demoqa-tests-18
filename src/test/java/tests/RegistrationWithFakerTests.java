package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static pages.RegistrationPage.*;
import static utils.RandomUtils.getRandomItemFromArray;


public class RegistrationWithFakerTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String gender = faker.demographic().sex();
        String email = faker.internet().emailAddress();
        String phoneNumber = 8 + faker.phoneNumber().subscriberNumber(9);
        String dayOfBirth = String.format("%02d", faker.number().numberBetween(1,28));
        String monthOfBirth = getRandomItemFromArray(months);
        String yearOfBirth = String.valueOf(faker.number().numberBetween(1950, 2005));
        String subject = getRandomItemFromArray(subjects);
        String hobbies = getRandomItemFromArray(hobbiess);
        String pictureName = "file.png";
        String currentAddress = faker.address().streetAddress();
        String state = "NCR";
        String city = getRandomItemFromArray(cities);


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


        registrationPage.verifyResultsModalAppears()
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
