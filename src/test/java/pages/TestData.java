package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TestData {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    File img = new File("src/test/resources/images/img.jpg");
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail");
    public TestData openPage() {
        open("/automation-practice-form");
        return this;
    }
    public TestData setFirstLastName() {
        firstNameInput.setValue("Testt");
        lastNameInput.setValue("Testov");
        return this;
    }
    public TestData setEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }
    public TestData setGenter(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }
    public TestData setPhone(String value) {
        $("#userNumber").setValue(value);
        return this;
    }
    public TestData setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public TestData setSubjects(String value) {
        $("#subjectsInput").setValue(value);
        return this;
    }
    public TestData setHobbies(String sports, String reading, String music) {
        $(byText(sports)).click();
        $(byText(reading)).click();
        $(byText(music)).click();
        return this;
    }
    public TestData setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }
    public TestData setSelectState(String value) {
        $(byText("Select State")).click();
        $(byText(value)).click();
        return this;
    }
    public TestData setUploadPicture() {
        $("#uploadPicture").uploadFile(img);
        return this;
    }
    public void setSubmit() {
        $("#submit").click();
    }
    public TestData setSelectCity(String value) {
        $("#city").click();
        $(byText(value)).click();
        return this;
    }

    public TestData resultsModal() {
        registrationResultsModal.resultsModalComponent();
        return this;
    }
    public TestData verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }
}
