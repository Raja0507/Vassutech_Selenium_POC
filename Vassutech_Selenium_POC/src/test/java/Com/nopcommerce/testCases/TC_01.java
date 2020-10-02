package Com.nopcommerce.testCases;


import Com.nopcommerce.ApplicationModule.HomePage;
import Com.nopcommerce.ApplicationModule.RegistrationPage;
import Com.nopcommerce.GenericMethods.GenericMethods;
import Com.nopcommerce.commontestannotations.CommonTestAnnotations;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_01 extends CommonTestAnnotations {

    @Test
    public void TC_01(){

        GenericMethods genericMethods=new GenericMethods();
        GenericMethods.Currenttestcase="TC_01";
        genericMethods.launchBrowser("CHROME","https://demo.nopcommerce.com/");
        HomePage homePage= HomePage.getInstance();
        homePage.navigateToRegisterPage();
        genericMethods.getScreenshot();
        RegistrationPage registrationPage =RegistrationPage.getInstance();
        registrationPage.fillRegistrationpage();
        genericMethods.getScreenshot();
        registrationPage.enterRegister();


    }

}
