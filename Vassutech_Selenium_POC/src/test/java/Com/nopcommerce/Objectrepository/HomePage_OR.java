package Com.nopcommerce.Objectrepository;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage_OR {
    @FindBy(xpath = "//a[text()='Register']") public WebElement lnk_Register;
    @FindBy(xpath = "//a[text()='Log in']']") public WebElement lnk_Login;

}

