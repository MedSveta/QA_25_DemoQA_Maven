package pages;

import dto.StudentDTO;
import dto.StudentLombok;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
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

    @FindBy(xpath = "//textarea[@placeholder='Current Address']")
    WebElement fieldCurrentAddress;

    @FindBy(id = "react-select-3-input")
    WebElement fieldState;

    @FindBy(id = "react-select-4-input")
    WebElement fieldCity;

    @FindBy(id = "submit")
    WebElement btnSubmit;

    @FindBy(id="example-modal-sizes-title-lg")
    WebElement textThanksFor;

    //+++++++++++++++++++++++++++++++++++
    //elements modal body

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    WebElement modalBodyNameLastName;
    @FindBy(xpath = "//tbody/tr[2]/td[2]")
    WebElement modalBodyEmail;
    @FindBy(xpath = "//tbody/tr[3]/td[2]")
    WebElement modalBodyGender;
    @FindBy(xpath = "//tbody/tr[4]/td[2]")
    WebElement modalBodyMobile;
    @FindBy(xpath = "//tbody/tr[5]/td[2]")
    WebElement modalBodyDateOfBirth;
    @FindBy(xpath = "//tbody/tr[6]/td[2]")
    WebElement modalBodySubjects;
    @FindBy(xpath = "//tbody/tr[7]/td[2]")
    WebElement modalBodyHobbies;
    @FindBy(xpath = "//tbody/tr[9]/td[2]")
    WebElement modalBodyAddress;
    @FindBy(xpath = "//tbody/tr[10]/td[2]")
    WebElement modalBodyStateCity;

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

        fieldCurrentAddress.sendKeys(student.getCurrentAddress());
        fieldState.sendKeys(student.getState());
        fieldState.sendKeys(Keys.ENTER);
        fieldCity.sendKeys(student.getCity());
        fieldCity.sendKeys(Keys.ENTER);

        return this;
    }

    public AutomationPracticeFormPage clickBtnSubmitPositive(){
        btnSubmit.click();
        return this;
    }
public boolean isElementPresent_textThanks(){
       return textThanksFor.isDisplayed();
}

    public StudentLombok createStudentFormPage(){
        return StudentLombok.builder()
                .name(modalBodyNameLastName.getText().split(" ")[0])
                .lastName(modalBodyNameLastName.getText().split(" ")[1])
                .email(modalBodyEmail.getText())
                .gender(returnGenderFromPage(modalBodyGender))
                .mobile(modalBodyMobile.getText())
                .dateOfBirth(modalBodyDateOfBirth.getText())
                .subjects(modalBodySubjects.getText())
                .currentAddress(modalBodyAddress.getText())
                .state(returnState(modalBodyStateCity))
                .city(returnCity(modalBodyStateCity))
                .build();
    }
    private String returnState(WebElement element){
        String[] arrayStr = element.getText().split(" ");
        if(arrayStr.length == 2){
            return arrayStr[0];
    }else if(arrayStr.length == 3){
            return (arrayStr[0]+" "+arrayStr[1]);
        }
        return null;
    }
    private String returnCity(WebElement element){
        String[] arrayStr = element.getText().split(" ");
        if(arrayStr.length == 2){
            return arrayStr[1];
        }else if(arrayStr.length == 3){
            return arrayStr[2];
        }
        return null;
    }
    private Gender returnGenderFromPage(WebElement elementGender){
        String strGender = elementGender.getText();

        switch (strGender){
            case "Male":{
                return Gender.MALE;
            }
            case "Female":{
                return Gender.FEMALE;
            }
            case "Other":{
                return Gender.OTHER;
            }
        }
        return null;
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
        String[] splitArray = subjects.split(", ");
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
