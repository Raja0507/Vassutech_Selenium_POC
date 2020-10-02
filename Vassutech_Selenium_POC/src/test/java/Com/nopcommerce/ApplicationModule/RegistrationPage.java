package Com.nopcommerce.ApplicationModule;


import Com.nopcommerce.GenericMethods.GenericMethods;
import Com.nopcommerce.Objectrepository.RegistrationPage_OR;
import Com.nopcommerce.fakerdata.FakerData;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends GenericMethods {


    private static RegistrationPage_OR registrationPage_or;
    private static RegistrationPage registrationPage;
    private FakerData data=FakerData.getInstance();

    private RegistrationPage() {
        System.out.println("Object created for Registration page and its OR");

        registrationPage_or = PageFactory.initElements(driver, RegistrationPage_OR.class);
    }

    public static RegistrationPage getInstance() {
        if (registrationPage == null) registrationPage = new RegistrationPage();
        return registrationPage;
    }
    @Step("Fill Registration form")
    public void fillRegistrationpage(){
        String Gender=getData("Gender"); //Read Jsonfile
//       String Gender=  data.getGender();      //faker class
        if(Gender.trim().equalsIgnoreCase("Male")){
            hoverAndclick("Registrationpage","Gender",registrationPage_or.rdo_Male);
        }else{
            hoverAndclick("Registrationpage","Gender",registrationPage_or.rdo_Female);
        }
        //fill First name
//    String Firstname=getData("First_Name"); //read json
        String Firstname= data.getFirstname();//getData("First_Name"); //Faker
        clickAndSendData("Registrationpage","Firstname",registrationPage_or.ipe_Firstname,Firstname);
        //fill last name
        // String Lastname=getData("Last_name"); //Json file
        String Lastname=data.getLastname();
        clickAndSendData("Registrationpage","Lastname",registrationPage_or.ipe_Lastname,Lastname);

        //fill day
//    SimpleDateFormat sdf=new SimpleDateFormat("HHmmssss");
//    Date d=new Date();

        String day=getData("DateofBirthDay");//Json file
        // String day=data.getDay();//Faker

        selectDropDownByVisibletext("Registration page","Day",registrationPage_or.Dropdwn_Day,day);

        //fill month

        String Month=getData("DateofBirthMonth");
        selectDropDownByVisibletext("Registration page","Month",registrationPage_or.Dropdwn_month,Month);

        //fill year
        String year=getData("DateofBirthYear");
        selectDropDownByVisibletext("Registration page","Year",registrationPage_or.Dropdwn_year,year);
        //file email

        //String Email=getData("Email");//Json file
        String Email=data.getEmail();
        clickAndSendData("Registrationpage","Email",registrationPage_or.ipe_Email,Email);

        //fill company name
        //String Companyname=getData("Company_name");//Jsonfile
        String Companyname=data.getCompany();//faker
        clickAndSendData("Registrationpage","Company name",registrationPage_or.ipe_Companyname,Companyname);
        //fill password

        //String Password=getData("Password");//Json file
        String Password=data.getPassword();  //faker
        clickAndSendData("registration page","Password",registrationPage_or.ipe_Password,Password);

        //fill confirm password
        //String ConfirmPassword=getData("ConfirmPassword");//json file
        String ConfirmPassword=data.getCnfpassword();
        clickAndSendData("Registration page","Confirm password",registrationPage_or.ipe_ConfirmPassword,ConfirmPassword);
        getScreenshot();
//    System.out.println(d+"----");

    }
    @Step("Enter on the register Button")
    public void enterRegister(){
        hoverAndclick("Registration Page","Register",registrationPage_or.lnk_Register);
        getScreenshot();
    }
}
