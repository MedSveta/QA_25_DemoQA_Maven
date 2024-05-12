package tests;

import dto.StudentDTO;
import enums.Gender;
import manager.ApplicationManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;

public class AutomationPracticeFormTests extends ApplicationManager {

    @Test
    public void automationPracticeFormPositiveTest(){
        StudentDTO student = new StudentDTO("Frodo", "Baggins", "frodobaggins@mail.com", Gender.FEMALE);
        HomePage homePage = new HomePage(getDriver());
        homePage.hideFooter();
        homePage.clickButtonForms()
                .clickBtnPracticeForm()
                .fillStudentForm(student);
    }
}
