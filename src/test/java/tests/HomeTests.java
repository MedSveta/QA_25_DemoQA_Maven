package tests;

import dto.StudentDTO;
import enums.Gender;
import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTests extends ApplicationManager {
@Test
    public void test(){
    StudentDTO student = new StudentDTO("Frodo", "Baggins", "frodobaggins@mail.com", Gender.FEMALE);
    HomePage homePage = new HomePage(getDriver());
    homePage.clickButtonForms()
            .clickBtnPracticeForm()
            .fillStudentForm(student);
}

}
