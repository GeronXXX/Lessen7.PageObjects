package practiceForm;

import org.junit.jupiter.api.Test;

public class PageObgects extends TestBase {
    @Test
    void practiceForm() {

        testData.openPage()
                .setFirstLastName()
                .setEmail("Testovich@test.ru")
                .setGenter("Other")
                .setPhone("89999999999")
                .setBirthDate("15", "March", "2000")
                .setSubjects("Moscow")
                .setHobbies("Sports", "Reading", "Music")
                .setCurrentAddress("Vetoshnyy Pereulok, 5, офис 219, Moscow, 109012")
                .setSelectState("Uttar Pradesh")
                .setSelectCity("Lucknow")
                .setUploadPicture()
                .setSubmit();

        testData.resultsModal()
                .verifyResult("Student Name", "Testt Testov")
                .verifyResult("Student Email", "Testovich@test.ru")
                .verifyResult("Gender", "Other")
                .verifyResult("Mobile", "8999999999")
                .verifyResult("Subjects", " ")
                .verifyResult("Hobbies", "Sports, Reading, Music")
                .verifyResult("Picture", "img.jpg")
                .verifyResult("Address", "Vetoshnyy Pereulok, 5, офис 219, Moscow, 109012")
                .verifyResult("State and City", "Uttar Pradesh Lucknow");

    }
}

