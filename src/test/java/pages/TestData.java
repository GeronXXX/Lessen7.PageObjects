package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TestData {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
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
    public TestData resultsModal() {
        registrationResultsModal.resultsModalComponent();

        return this;
    }
    public TestData verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }
}
