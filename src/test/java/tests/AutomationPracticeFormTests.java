package tests;

import dto.StudentDTO;
import dto.StudentLombok;
import enums.Gender;
import enums.Hobbies;
import manager.ApplicationManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;

import java.util.ArrayList;

public class AutomationPracticeFormTests extends ApplicationManager {

    @Test
    public void automationPracticeFormPositiveTest(){
        ArrayList<Hobbies> listHobbies = new ArrayList<>();
        listHobbies.add(Hobbies.MUSIC);
        listHobbies.add(Hobbies.READING);
        listHobbies.add(Hobbies.SPORTS);
        //StudentDTO student = new StudentDTO("Frodo", "Baggins", "frodobaggins@mail.com", Gender.FEMALE);
        StudentLombok student = StudentLombok.builder()
                .name("Frodo").lastName("Baggins").email("bag_mail@mail.com")
                .gender(Gender.MALE).mobile("1234567890").dateOfBirth("12 Sep 2006")
                .subjects("Maths,Arts,History").hobbies(listHobbies).build();
        HomePage homePage = new HomePage(getDriver());
        homePage.hideFooter();
        homePage.clickButtonForms()
                .clickBtnPracticeForm()
                .fillStudentForm(student);
    }
}
