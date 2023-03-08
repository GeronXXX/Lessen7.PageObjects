package practiceForm;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PageObgecta extends TestBase {
    @Test
    void practiceForm() {

        File img = new File("src/test/resources/images/img.jpg");

        testData.openPage()
                .setFirstLastName()
                .setEmail("Testovich@test.ru")
                .setGenter("Other")
                .setPhone("89999999999")
                .setBirthDate("15", "March", "2000");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("2000");
        $(byText("13")).click();
        $("#subjectsInput").setValue("Moscow");
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#currentAddress").setValue("Vetoshnyy Pereulok, 5, офис 219, Moscow, 109012");
        $(byText("Select State")).click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Lucknow")).click();
        $("#uploadPicture").uploadFile(img);
        $("#submit").click();

        testData.resultsModal()
                .verifyResult("Student Name", "Testt Testov");

        $(".table-responsive").shouldHave(text("Testt Testov"), text("Testovich@test.ru"),
                text("Other"), text("8999999999"), text("13 March,2023"), text("Sports, Reading, Music"),
                text("img.jpg"), text("Vetoshnyy Pereulok, 5, офис 219, Moscow, 109012"),
                text("Uttar Pradesh Lucknow"));
    }
}

