package Com.nopcommerce.Objectrepository;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage_OR {
    @FindBy(xpath = "//input[@id='gender-male']") public WebElement rdo_Male;
    @FindBy(xpath = "//input[@id='gender-female']") public WebElement rdo_Female;
    @FindBy(xpath = "//input[@id='FirstName']") public WebElement ipe_Firstname;
    @FindBy(xpath = "//input[@id='LastName']") public WebElement ipe_Lastname;
    @FindBy(xpath = "//div[@class='inputs date-of-birth']//select[1]") public WebElement Dropdwn_Day;
    @FindBy(xpath = "//div[@class='inputs date-of-birth']//select[2]") public WebElement Dropdwn_month;
    @FindBy(xpath = "//div[@class='inputs date-of-birth']//select[3]") public WebElement Dropdwn_year;
    @FindBy(xpath = "//input[@id='Email']") public WebElement ipe_Email;
    @FindBy(xpath = "//input[@id='Company']") public WebElement ipe_Companyname;
    @FindBy(xpath = "//input[@id='Password']") public WebElement ipe_Password;
    @FindBy(xpath = "//input[@id='ConfirmPassword']") public WebElement ipe_ConfirmPassword;
    @FindBy(xpath = "//input[@id='register-button']") public WebElement lnk_Register;

}

