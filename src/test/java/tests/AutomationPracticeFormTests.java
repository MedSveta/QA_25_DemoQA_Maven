package tests;

import dto.StudentDTO;
import dto.StudentLombok;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.ApplicationManager;
import org.testng.Assert;
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
                .subjects("Maths, Arts, History").hobbies(listHobbies)
                .currentAddress("Haifa st. First")
                .state(StateCity.UTTAR_PRADESH.getState())
                .city(StateCity.UTTAR_PRADESH.getCity()[1])
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.hideFooter();
        Assert.assertTrue(homePage.clickButtonForms()
                .clickBtnPracticeForm()
                .fillStudentForm(student)
                .clickBtnSubmitPositive().isElementPresent_textThanks());
    }
    @Test
    public void automationPracticeFormPositiveTest_equalsStudent(){
        ArrayList<Hobbies> listHobbies = new ArrayList<>();
        listHobbies.add(Hobbies.MUSIC);
        listHobbies.add(Hobbies.READING);
        listHobbies.add(Hobbies.SPORTS);

        StudentLombok student = StudentLombok.builder()
                .name("Frodo").lastName("Baggins").email("bag_mail@mail.com")
                .gender(Gender.MALE).mobile("1234567890").dateOfBirth("12 Sep 2006")
                .subjects("Maths, Arts").hobbies(listHobbies)
                .currentAddress("Haifa st. First app.12")
                .state(StateCity.NCR.getState())
                .city(StateCity.NCR.getCity()[1])
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.hideFooter();
        StudentLombok studentModal = homePage.clickButtonForms()
                .clickBtnPracticeForm()
                .fillStudentForm(student)
                .clickBtnSubmitPositive()
                .createStudentFormPage();
        System.out.println(student.toString());
        System.out.println(studentModal.toString());
        Assert.assertTrue(student.equals(studentModal));
    }
}
