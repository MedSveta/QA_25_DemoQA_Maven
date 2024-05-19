package pages;

import dto.StudentDTO;
import dto.StudentLombok;
import enums.Gender;
import enums.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class AutomationPracticeFormPage extends BasePage {
    public AutomationPracticeFormPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement fieldName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement fieldLastName;

    @FindBy(xpath = "//input[@placeholder='name@example.com']")
    WebElement fieldEmail;

    @FindBy(xpath = "//input[@placeholder='Mobile Number']")
    WebElement fieldMobile;

    @FindBy(id = "dateOfBirthInput")
    WebElement fieldDateOfBirth;

    @FindBy(id = "subjectsInput")
    WebElement fieldSubjects;

    public AutomationPracticeFormPage fillStudentForm(StudentLombok student) {
        hideFooter();
        fieldName.sendKeys(student.getName());
        fieldLastName.sendKeys(student.getLastName());
        fieldEmail.sendKeys(student.getEmail());
        clickGender(student.getGender());

        fieldMobile.sendKeys(student.getMobile());
        //fieldDateOfBirth.sendKeys(student.getDateOfBirth());
        typeDateOfBirth(student.getDateOfBirth());
        typeSubjects(student.getSubjects());
        typeHobbies(student.getHobbies());

        return this;
    }

    private void typeHobbies(List<Hobbies> hobbiesList) {
        for (Hobbies h:
            hobbiesList ) {
            switch (h){
                case SPORTS:driver.findElement(By.xpath(h.getLocator())).click();
                break;
                case READING:driver.findElement(By.xpath(h.getLocator())).click();
                break;
                case MUSIC:driver.findElement(By.xpath(h.getLocator())).click();
                break;
            }

        }
    }

    private void typeSubjects(String subjects) {
        String[] splitArray = subjects.split(",");
        fieldSubjects.click();
        for (String sub:splitArray
             ) {
            fieldSubjects.sendKeys(sub);
            fieldSubjects.sendKeys(Keys.ENTER);
        }
    }

    private void typeDateOfBirth(String dateOfBirth) {
        fieldDateOfBirth.click();
        String operationSystem = System.getProperty("os.name");
        System.out.println("OS --> "+operationSystem);
        if(operationSystem.startsWith("Win"))
        fieldDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        else if(operationSystem.startsWith("Mac"))
            fieldDateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        fieldDateOfBirth.sendKeys(dateOfBirth);
        fieldDateOfBirth.sendKeys(Keys.ENTER);
    }

    private void clickGender(Gender gender) {
        WebElement elementGender = driver.findElement(By.xpath(gender.getLocator()));
        elementGender.click();
    }
}
