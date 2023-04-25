package guru.qa.homework.tests;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Selenide.*;
import com.github.javafaker.*;
import guru.qa.homework.utils.RandomUtils;


public class TestWebForm extends TestBase {
    Faker data = new Faker();
    File fileJpeg = new File("src/test/resources/download.jpeg");
    String
            firstName = data.name().firstName(),
            lastName = data.name().lastName(),
            email = data.internet().emailAddress(),
            gender = RandomUtils.getRandomGender(),
            phoneNumber = data.numerify("##########"),
            birthDayMonth = RandomUtils.getRandomMonth(),
            birthDayYear = Integer.toString(data.number().numberBetween(2000,2022)),
            birthDayDate = Integer.toString(data.number().numberBetween(1,28)),
            subject = RandomUtils.getRandomSubject(),
            hobbies = RandomUtils.getRandomHobbie(),
            fileName = "download.jpeg",
            address = data.address().fullAddress(),
            state = RandomUtils.getRandomState(),
            city = RandomUtils.getRandomCity(state);

    @Test
    public void testWebForm() {
        open();
        registrationPage.openPage()
                        .closeBanners()
                        .setLastName(lastName)
                        .setFirstName(firstName)
                        .chooseEmail(email)
                        .chooseGender(gender)
                        .setPhoneNumber(phoneNumber);
        calendar.setCalendarDate(birthDayDate, birthDayMonth, birthDayYear);
        registrationPage.setSubject(subject)
                        .chooseHobbie(hobbies)
                        .uploadPicture(fileJpeg)
                        .setAddress(address)
                        .chooseState(state)
                        .chooseCity(city)
                        .clickSubmit()
                //result assert
                        .verifyResult("Student Name", firstName+" "+lastName)
                        .verifyResult("Student Email",email)
                        .verifyResult("Gender",gender)
                        .verifyResult("Mobile", phoneNumber)
                        .verifyResult("Date of Birth", birthDayDate +" "+ birthDayMonth +","+ birthDayYear)
                        .verifyResult("Subjects", subject)
                        .verifyResult("Hobbies", hobbies)
                        .verifyResult("Picture",fileName)
                        .verifyResult("Address", address)
                        .verifyResult("State and City", state +" "+ city);
        registrationPage.clickCloseModal();



        //Мусор:
        //$("#dateOfBirthInput").scrollIntoView(true).click(); //на макбук 13" элементы слишком плотно расоложены друг. Корректно ли решать через scrollIntoView?
        //$(".react-datepicker__month-select").$(byText("March")).click();
        //$(".react-datepicker__year-select").$(byText("1997")).click();
        //$(byText("11")).click();

        //$("#subjectsInput").setValue("Physics").pressEnter();
        //$(byText("Music")).click();
        //$("#uploadPicture").uploadFile(new File("src/test/resources/download.jpeg"));
        //$("#currentAddress").setValue("Tsotne dadiani 25");
        //$("#react-select-3-input").scrollIntoView(true).setValue("Haryana").pressEnter();
        //$("#react-select-4-input").setValue("Panipat").pressEnter();
        //$("#submit").click();
        //Валидация значений и закрытие модального окна

//        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(Condition.text("Alexander Sergievich"));
//        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(Condition.text("stackinthecorner@gmail.com"));
//        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(Condition.text("Female"));
//        //здесь и далее по какой-то причине не получается найти элемент byText, почему так? Структура html идентична для всей таблицы.
//        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(Condition.text("11 July,1901"));
//        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(Condition.text("Physics"));
//        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(Condition.text("Music"));
//        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(Condition.text("download.jpeg"));
//        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(Condition.text("Tsotne dadiani 25"));
//        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(Condition.text("Haryana Panipat"));
//        registrationPage.setCloseModal();



        /*$(byTagName("tbody")).$$(byTagName("tr")).get(3).shouldHave(Condition.text("8796504478"));
        $(byTagName("tbody")).$$(byTagName("tr")).get(4).shouldHave(Condition.text("11 March,1997"));
        $(byTagName("tbody")).$$(byTagName("tr")).get(5).shouldHave(Condition.text("Physics"));
        $(byTagName("tbody")).$$(byTagName("tr")).get(6).shouldHave(Condition.text("Music"));
        $(byTagName("tbody")).$$(byTagName("tr")).get(7).shouldHave(Condition.text("download.jpeg"));
        $(byText("Address")).sibling(0).shouldHave(Condition.text("Tsotne dadiani 25"));
        $(byTagName("tbody")).$$(byTagName("tr")).get(9).shouldHave(Condition.text("Haryana Panipat"));
        $("#closeLargeModal").click();*/

    }
}
