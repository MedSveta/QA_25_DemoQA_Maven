package tests;

import dto.StudentDTO;
import dto.StudentLombok;
import enums.Gender;
import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTests extends ApplicationManager {
@Test
    public void test(){
    StudentLombok student = StudentLombok.builder()
            .name("Frodo").lastName("Baggins").email("bag_mail@mail.com").gender(Gender.MALE).build();
    HomePage homePage = new HomePage(getDriver());
    homePage.clickButtonForms()
            .clickBtnPracticeForm()
            .fillStudentForm(student);
}

}
