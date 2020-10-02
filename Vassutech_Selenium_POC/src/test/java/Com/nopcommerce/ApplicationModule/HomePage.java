package Com.nopcommerce.ApplicationModule;


import Com.nopcommerce.GenericMethods.GenericMethods;
import Com.nopcommerce.Objectrepository.HomePage_OR;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends GenericMethods {
    private static HomePage_OR homePage_or;
    private static HomePage homePage;
    private HomePage(){
        System.out.println("Object created for Home page and its OR");
        //homePage_or=new HomePage_OR();//
        homePage_or= PageFactory.initElements(driver,HomePage_OR.class);
    }

    public static HomePage getInstance(){
        if(homePage==null) homePage=new HomePage();
        return homePage;
    }
    @Step("Navigating to register Page")
    public void navigateToRegisterPage(){
        hoverAndclick("homepage","Register",homePage_or.lnk_Register);
    }
    public void navigateToLoginPage(){
        getScreenshot();
    }
}

