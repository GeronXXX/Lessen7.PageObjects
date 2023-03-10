package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PageObgects {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genterWrapper = $("#genterWrapper");
    private final SelenideElement userNumber = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement SelectState = $(byText("Select State"));
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement city = $("#city");
    private final SelenideElement submit = $("#submit");
    public PageObgects openPage() {
        open("/automation-practice-form");
        return this;
    }
    public PageObgects setFirstLastName(String firstName, String lestName) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lestName);
        return this;
    }
    public PageObgects setEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }
    public PageObgects setGenter(String value) {
        genterWrapper.$(byText(value)).click();
        return this;
    }
    public PageObgects setPhone(String value) {
        userNumber.setValue(value);
        return this;
    }
    public PageObgects setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public PageObgects setSubjects(String value) {
        subjectsInput.setValue(value);
        return this;
    }
    public PageObgects setHobbies(String value) {
        $(byText(value)).click();
        return this;
    }
    public PageObgects setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }
    public PageObgects setSelectState(String value) {
        SelectState.click();
        $(byText(value)).click();
        return this;
    }
    public PageObgects setSelectCity(String value) {
        city.click();
        $(byText(value)).click();
        return this;
    }
    public PageObgects setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }
    public void setSubmit() {
        submit.click();
    }
    public PageObgects resultsModal() {
        registrationResultsModal.resultsModalComponent();
        return this;
    }
    public PageObgects verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }
}