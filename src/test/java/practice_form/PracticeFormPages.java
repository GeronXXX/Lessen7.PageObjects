package practice_form;

import org.junit.jupiter.api.Test;
import pages.PageObgects;

public class PracticeFormPages extends TestBase {
    PageObgects pageObgects = new PageObgects();
    @Test
    void practiceFormTest() {

        pageObgects.openPage()
                .setFirstLastName("Testt","Testov")
                .setEmail("Testovich@test.ru")
                .setGenter("Other")
                .setPhone("89999999999")
                .setBirthDate("15", "March", "2000")
                .setSubjects("Moscow")
                .setHobbies("Sports")
                .setCurrentAddress("Vetoshnyy Pereulok, 5, Moscow, 109012")
                .setSelectState("Uttar Pradesh")
                .setSelectCity("Lucknow")
                .setUploadPicture("images/img.jpg")
                .setSubmit();

        pageObgects.resultsModal()
                .verifyResult("Student Name", "Testt Testov")
                .verifyResult("Student Email", "Testovich@test.ru")
                .verifyResult("Gender", "Other")
                .verifyResult("Mobile", "8999999999")
                .verifyResult("Date of Birth", "15 March,2000")
                .verifyResult("Subjects", " ")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "img.jpg")
                .verifyResult("Address", "Vetoshnyy Pereulok, 5, Moscow, 109012")
                .verifyResult("State and City", "Uttar Pradesh Lucknow");

    }
}

